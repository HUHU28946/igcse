package com.example.data.model

enum class QualificationLevel(val label: String, val shortName: String, val description: String) {
    IGCSE("Cambridge & Edexcel IGCSE", "IGCSE", "International General Certificate of Secondary Education (Ages 14-16)"),
    AS_LEVEL("Cambridge & Edexcel AS Level", "AS Level", "Advanced Subsidiary Level - Stage 1 of A Level (Year 12)"),
    A_LEVEL("Cambridge & Edexcel A Level", "A Level", "Full Advanced Level (A2/A Level - Year 13)")
}

data class Subject(
    val id: String,
    val name: String,
    val code: String,
    val level: QualificationLevel,
    val examBoard: String, // e.g. Cambridge CAIE, Pearson Edexcel
    val category: String,  // Sciences, Mathematics, Computing, Humanities, Commerce
    val accentColorHex: Long,
    val summary: String,
    val currentSyllabusPeriod: String, // e.g. 2025–2027
    val keySyllabusUpdates: List<String>,
    val paperStructure: List<PaperInfo>,
    val chapters: List<Chapter>
)

data class PaperInfo(
    val paperName: String,
    val duration: String,
    val marks: Int,
    val weightPercentage: Int,
    val calculatorAllowed: Boolean,
    val formatDescription: String
)

data class Chapter(
    val id: String,
    val chapterNumber: Int,
    val title: String,
    val description: String,
    val lessons: List<Lesson>
)

data class Lesson(
    val id: String,
    val chapterId: String,
    val title: String,
    val estimatedReadMinutes: Int,
    val summary: String,
    val keyConcepts: List<String>,
    val syllabusReferences: String,
    val notes: List<NoteSection>,
    val formulas: List<FormulaItem>,
    val examinerTips: List<String>,
    val workedExamples: List<WorkedExample>
)

data class NoteSection(
    val heading: String,
    val bullets: List<String>
)

data class FormulaItem(
    val name: String,
    val formula: String,
    val whereVariables: String
)

data class WorkedExample(
    val title: String,
    val question: String,
    val steps: List<String>,
    val answer: String,
    val examinerInsight: String
)

data class ExerciseQuestion(
    val id: String,
    val subjectId: String,
    val subjectCode: String,
    val level: QualificationLevel,
    val topic: String,
    val questionText: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String,
    val marks: Int,
    val examinerPitfall: String
)

data class PastPaper(
    val id: String,
    val subjectId: String,
    val subjectCode: String,
    val subjectName: String,
    val level: QualificationLevel,
    val year: String,
    val series: String, // e.g. "May/June", "Oct/Nov", "Feb/March", "Specimen 2025"
    val paperNumber: String, // e.g. "Paper 2 (Extended)", "Paper 4 (Theory)"
    val paperCode: String, // e.g. "0580/22", "9709/12"
    val duration: String,
    val maxMarks: Int,
    val gradeThresholds: GradeThreshold,
    val sampleQuestions: List<PaperQuestionPreview>,
    val examinerKeyAdvice: List<String>
)

data class GradeThreshold(
    val aStar: Int,
    val gradeA: Int,
    val gradeB: Int,
    val gradeC: Int,
    val gradeD: Int,
    val gradeE: Int
)

data class PaperQuestionPreview(
    val qNumber: String,
    val questionText: String,
    val marks: Int,
    val markSchemeSolution: String
)

data class SyllabusCodeUpdate(
    val id: String,
    val title: String,
    val subjectName: String,
    val oldCode: String?,
    val currentCode: String,
    val level: QualificationLevel,
    val examBoard: String,
    val effectiveYears: String,
    val updateType: UpdateCategory,
    val urgency: UpdateUrgency,
    val datePosted: String,
    val overview: String,
    val detailedChanges: List<String>,
    val examBoardAdvice: String
)

enum class UpdateCategory(val label: String) {
    SYLLABUS_REVISION("Syllabus & Code Revision"),
    CALCULATOR_POLICY("Calculator Policy"),
    ASSESSMENT_RESTRUCTURE("Paper Structure Change"),
    FORMULA_SHEET("Formula Sheet Change"),
    TIMETABLE_EXAM_ALERT("Exam Timetable & Dates")
}

enum class UpdateUrgency(val label: String) {
    CRITICAL("Crucial for 2025/2026 Exams"),
    IMPORTANT("Noticeable Changes"),
    INFO("General Update")
}
