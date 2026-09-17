package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entities.BookmarkedItemEntity
import com.example.data.local.entities.QuizRecordEntity
import com.example.data.local.entities.StudyNoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StudyDao {

    // Bookmarks
    @Query("SELECT * FROM bookmarks ORDER BY timestamp DESC")
    fun getAllBookmarks(): Flow<List<BookmarkedItemEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarks WHERE id = :id)")
    fun isBookmarked(id: String): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmark: BookmarkedItemEntity)

    @Query("DELETE FROM bookmarks WHERE id = :id")
    suspend fun deleteBookmarkById(id: String)

    // Quiz records
    @Query("SELECT * FROM quiz_records ORDER BY timestamp DESC")
    fun getAllQuizRecords(): Flow<List<QuizRecordEntity>>

    @Query("SELECT * FROM quiz_records WHERE subjectId = :subjectId ORDER BY timestamp DESC")
    fun getQuizRecordsBySubject(subjectId: String): Flow<List<QuizRecordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuizRecord(record: QuizRecordEntity)

    // Student notes
    @Query("SELECT * FROM study_notes ORDER BY updatedAt DESC")
    fun getAllNotes(): Flow<List<StudyNoteEntity>>

    @Query("SELECT * FROM study_notes WHERE subjectId = :subjectId ORDER BY updatedAt DESC")
    fun getNotesBySubject(subjectId: String): Flow<List<StudyNoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: StudyNoteEntity)

    @Query("DELETE FROM study_notes WHERE id = :id")
    suspend fun deleteNoteById(id: Long)
}
