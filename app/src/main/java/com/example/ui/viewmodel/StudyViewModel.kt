package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.StudyDatabase
import com.example.data.local.entities.BookmarkedItemEntity
import com.example.data.local.entities.QuizRecordEntity
import com.example.data.local.entities.StudyNoteEntity
import com.example.data.model.*
import com.example.data.repository.StudyRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class StudyUiState(
    val currentLevel: QualificationLevel = QualificationLevel.IGCSE,
    val selectedSubject: Subject? = null,
    val subjectTab: SubjectTab = SubjectTab.LESSONS_NOTES,
    val activeLesson: Lesson? = null,
    val activePastPaper: PastPaper? = null,
    val activeUpdateDetail: SyllabusCodeUpdate? = null,
    val mainNavigationTab: MainNavTab = MainNavTab.SUBJECTS,
    val updateCategoryFilter: UpdateCategory? = null,
    val searchQuery: String = "",
    val answeredQuestions: Map<String, Int> = emptyMap(), // questionId -> selectedOptionIndex
    val isNoteDialogOpen: Boolean = false,
    val newNoteTitle: String = "",
    val newNoteContent: String = "",
    val messageBanner: String? = null
)

enum class MainNavTab(val label: String) {
    SUBJECTS("Subjects"),
    UPDATES("Exam Updates"),
    PRACTICE("Practice"),
    REVISION_DESK("Revision Desk")
}

enum class SubjectTab(val label: String) {
    SYLLABUS_OVERVIEW("Syllabus & Codes"),
    LESSONS_NOTES("Lessons & Notes"),
    EXERCISES("Exercises"),
    PAST_PAPERS("Past Papers")
}

class StudyViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: StudyRepository

    init {
        val database = StudyDatabase.getDatabase(application)
        repository = StudyRepository(database.studyDao())
    }

    private val _uiState = MutableStateFlow(StudyUiState())
    val uiState: StateFlow<StudyUiState> = _uiState.asStateFlow()

    val bookmarks: StateFlow<List<BookmarkedItemEntity>> = repository.allBookmarks
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val quizRecords: StateFlow<List<QuizRecordEntity>> = repository.allQuizRecords
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val studyNotes: StateFlow<List<StudyNoteEntity>> = repository.allNotes
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun setQualificationLevel(level: QualificationLevel) {
        _uiState.update { current ->
            val newSelectedSubject = if (current.selectedSubject?.level == level) current.selectedSubject else null
            current.copy(
                currentLevel = level,
                selectedSubject = newSelectedSubject,
                activeLesson = null,
                activePastPaper = null
            )
        }
    }

    fun selectSubject(subject: Subject?) {
        _uiState.update { it.copy(selectedSubject = subject, activeLesson = null, activePastPaper = null) }
    }

    fun setMainNavTab(tab: MainNavTab) {
        _uiState.update { it.copy(mainNavigationTab = tab) }
    }

    fun setSubjectTab(tab: SubjectTab) {
        _uiState.update { it.copy(subjectTab = tab) }
    }

    fun openLesson(lesson: Lesson) {
        _uiState.update { it.copy(activeLesson = lesson) }
    }

    fun closeLesson() {
        _uiState.update { it.copy(activeLesson = null) }
    }

    fun openPastPaper(paper: PastPaper) {
        _uiState.update { it.copy(activePastPaper = paper) }
    }

    fun closePastPaper() {
        _uiState.update { it.copy(activePastPaper = null) }
    }

    fun openUpdateDetail(update: SyllabusCodeUpdate?) {
        _uiState.update { it.copy(activeUpdateDetail = update) }
    }

    fun setUpdateCategoryFilter(category: UpdateCategory?) {
        _uiState.update { it.copy(updateCategoryFilter = category) }
    }

    fun setSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun answerQuestion(question: ExerciseQuestion, selectedIndex: Int) {
        val currentAnswers = _uiState.value.answeredQuestions.toMutableMap()
        if (currentAnswers.containsKey(question.id)) return // already answered
        currentAnswers[question.id] = selectedIndex
        _uiState.update { it.copy(answeredQuestions = currentAnswers) }

        val isCorrect = selectedIndex == question.correctIndex
        viewModelScope.launch {
            repository.recordQuizAttempt(question, selectedIndex, isCorrect)
        }
    }

    fun toggleLessonBookmark(lesson: Lesson, subject: Subject) {
        val isBookmarked = bookmarks.value.any { it.id == lesson.id }
        viewModelScope.launch {
            repository.toggleBookmark(
                id = lesson.id,
                isBookmarked = isBookmarked,
                type = "LESSON",
                title = lesson.title,
                subtitle = "${subject.name} (${subject.code}) - ${lesson.summary}",
                subjectId = subject.id,
                subjectName = subject.name,
                subjectCode = subject.code,
                levelName = subject.level.shortName
            )
            _uiState.update {
                it.copy(messageBanner = if (isBookmarked) "Removed from bookmarks" else "Saved to Revision Desk!")
            }
        }
    }

    fun togglePastPaperBookmark(paper: PastPaper) {
        val isBookmarked = bookmarks.value.any { it.id == paper.id }
        viewModelScope.launch {
            repository.toggleBookmark(
                id = paper.id,
                isBookmarked = isBookmarked,
                type = "PAST_PAPER",
                title = "${paper.subjectName} ${paper.year} ${paper.series}",
                subtitle = "${paper.paperNumber} (${paper.paperCode})",
                subjectId = paper.subjectId,
                subjectName = paper.subjectName,
                subjectCode = paper.subjectCode,
                levelName = paper.level.shortName
            )
            _uiState.update {
                it.copy(messageBanner = if (isBookmarked) "Removed past paper bookmark" else "Past paper saved to Revision Desk!")
            }
        }
    }

    fun dismissMessageBanner() {
        _uiState.update { it.copy(messageBanner = null) }
    }

    fun openNoteDialog(title: String = "", content: String = "") {
        _uiState.update { it.copy(isNoteDialogOpen = true, newNoteTitle = title, newNoteContent = content) }
    }

    fun closeNoteDialog() {
        _uiState.update { it.copy(isNoteDialogOpen = false, newNoteTitle = "", newNoteContent = "") }
    }

    fun updateNoteInputs(title: String, content: String) {
        _uiState.update { it.copy(newNoteTitle = title, newNoteContent = content) }
    }

    fun saveStudentNote(subject: Subject?) {
        val title = _uiState.value.newNoteTitle.trim()
        val content = _uiState.value.newNoteContent.trim()
        if (title.isEmpty()) return

        val subjId = subject?.id ?: "general"
        val subjName = subject?.name ?: "General Studies"
        val subjCode = subject?.code ?: "General"
        val lvl = subject?.level?.shortName ?: _uiState.value.currentLevel.shortName

        viewModelScope.launch {
            repository.saveNote(
                subjectId = subjId,
                subjectName = subjName,
                subjectCode = subjCode,
                levelName = lvl,
                title = title,
                content = content
            )
            closeNoteDialog()
            _uiState.update { it.copy(messageBanner = "Study note saved successfully!") }
        }
    }

    fun deleteStudentNote(id: Long) {
        viewModelScope.launch {
            repository.deleteNote(id)
            _uiState.update { it.copy(messageBanner = "Note deleted") }
        }
    }

    // Filtered data accessors
    fun getSubjectsForCurrentLevel(): List<Subject> {
        val query = _uiState.value.searchQuery.trim().lowercase()
        val list = repository.getSubjectsByLevel(_uiState.value.currentLevel)
        if (query.isEmpty()) return list
        return list.filter {
            it.name.lowercase().contains(query) ||
            it.code.lowercase().contains(query) ||
            it.summary.lowercase().contains(query)
        }
    }

    fun getSyllabusUpdates(): List<SyllabusCodeUpdate> {
        val filterLevel = _uiState.value.currentLevel
        val filterCat = _uiState.value.updateCategoryFilter
        val query = _uiState.value.searchQuery.trim().lowercase()
        return repository.getSyllabusUpdates(filterLevel, filterCat).filter {
            query.isEmpty() ||
            it.title.lowercase().contains(query) ||
            it.subjectName.lowercase().contains(query) ||
            it.currentCode.lowercase().contains(query) ||
            it.overview.lowercase().contains(query)
        }
    }

    fun getPastPapersForCurrentSubject(): List<PastPaper> {
        val subj = _uiState.value.selectedSubject
        return repository.getPastPapers(subj?.id, _uiState.value.currentLevel)
    }

    fun getExercisesForCurrentSubject(): List<ExerciseQuestion> {
        val subj = _uiState.value.selectedSubject
        return repository.getExercises(subj?.id, _uiState.value.currentLevel)
    }

    fun getAllExercisesForCurrentLevel(): List<ExerciseQuestion> {
        return repository.getExercises(null, _uiState.value.currentLevel)
    }
}
