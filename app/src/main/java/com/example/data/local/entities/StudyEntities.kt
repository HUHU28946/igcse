package com.example.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
data class BookmarkedItemEntity(
    @PrimaryKey val id: String, // e.g. lesson id or paper id
    val itemType: String, // "LESSON" or "PAST_PAPER"
    val title: String,
    val subtitle: String,
    val subjectId: String,
    val subjectName: String,
    val subjectCode: String,
    val levelName: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "quiz_records")
data class QuizRecordEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val questionId: String,
    val subjectId: String,
    val subjectName: String,
    val levelName: String,
    val topic: String,
    val selectedIndex: Int,
    val correctIndex: Int,
    val isCorrect: Boolean,
    val marksAwarded: Int,
    val maxMarks: Int,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "study_notes")
data class StudyNoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val subjectId: String,
    val subjectName: String,
    val subjectCode: String,
    val levelName: String,
    val title: String,
    val content: String,
    val tags: String = "",
    val updatedAt: Long = System.currentTimeMillis()
)
