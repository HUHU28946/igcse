package com.example.data.repository

import com.example.data.local.dao.StudyDao
import com.example.data.local.entities.BookmarkedItemEntity
import com.example.data.local.entities.QuizRecordEntity
import com.example.data.local.entities.StudyNoteEntity
import com.example.data.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class StudyRepository(private val studyDao: StudyDao) {

    // Subjects & Levels
    fun getSubjectsByLevel(level: QualificationLevel): List<Subject> {
        return StudyDataProvider.allSubjects.filter { it.level == level }
    }

    fun getSubjectById(subjectId: String): Subject? {
        return StudyDataProvider.allSubjects.find { it.id == subjectId }
    }

    fun getAllSubjects(): List<Subject> = StudyDataProvider.allSubjects

    // Syllabus Code Updates
    fun getSyllabusUpdates(level: QualificationLevel? = null, category: UpdateCategory? = null): List<SyllabusCodeUpdate> {
        return StudyDataProvider.syllabusUpdates.filter { update ->
            (level == null || update.level == level) &&
            (category == null || update.updateType == category)
        }
    }

    // Past Papers
    fun getPastPapers(subjectId: String? = null, level: QualificationLevel? = null): List<PastPaper> {
        return StudyDataProvider.samplePastPapers.filter { paper ->
            (subjectId == null || paper.subjectId == subjectId) &&
            (level == null || paper.level == level)
        }
    }

    // Exercises
    fun getExercises(subjectId: String? = null, level: QualificationLevel? = null): List<ExerciseQuestion> {
        return StudyDataProvider.sampleExercises.filter { ex ->
            (subjectId == null || ex.subjectId == subjectId) &&
            (level == null || ex.level == level)
        }
    }

    // Room DB: Bookmarks
    val allBookmarks: Flow<List<BookmarkedItemEntity>> = studyDao.getAllBookmarks()

    fun isItemBookmarked(id: String): Flow<Boolean> = studyDao.isBookmarked(id)

    suspend fun toggleBookmark(
        id: String,
        isBookmarked: Boolean,
        type: String,
        title: String,
        subtitle: String,
        subjectId: String,
        subjectName: String,
        subjectCode: String,
        levelName: String
    ) {
        if (isBookmarked) {
            studyDao.deleteBookmarkById(id)
        } else {
            studyDao.insertBookmark(
                BookmarkedItemEntity(
                    id = id,
                    itemType = type,
                    title = title,
                    subtitle = subtitle,
                    subjectId = subjectId,
                    subjectName = subjectName,
                    subjectCode = subjectCode,
                    levelName = levelName
                )
            )
        }
    }

    // Room DB: Quiz records
    val allQuizRecords: Flow<List<QuizRecordEntity>> = studyDao.getAllQuizRecords()

    suspend fun recordQuizAttempt(
        question: ExerciseQuestion,
        selectedIndex: Int,
        isCorrect: Boolean
    ) {
        val marksAwarded = if (isCorrect) question.marks else 0
        studyDao.insertQuizRecord(
            QuizRecordEntity(
                questionId = question.id,
                subjectId = question.subjectId,
                subjectName = question.subjectCode,
                levelName = question.level.shortName,
                topic = question.topic,
                selectedIndex = selectedIndex,
                correctIndex = question.correctIndex,
                isCorrect = isCorrect,
                marksAwarded = marksAwarded,
                maxMarks = question.marks
            )
        )
    }

    // Room DB: Study notes
    val allNotes: Flow<List<StudyNoteEntity>> = studyDao.getAllNotes()

    suspend fun saveNote(
        subjectId: String,
        subjectName: String,
        subjectCode: String,
        levelName: String,
        title: String,
        content: String
    ) {
        studyDao.insertNote(
            StudyNoteEntity(
                subjectId = subjectId,
                subjectName = subjectName,
                subjectCode = subjectCode,
                levelName = levelName,
                title = title,
                content = content
            )
        )
    }

    suspend fun deleteNote(id: Long) {
        studyDao.deleteNoteById(id)
    }
}
