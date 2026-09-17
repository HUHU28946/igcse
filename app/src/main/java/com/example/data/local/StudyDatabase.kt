package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.local.dao.StudyDao
import com.example.data.local.entities.BookmarkedItemEntity
import com.example.data.local.entities.QuizRecordEntity
import com.example.data.local.entities.StudyNoteEntity

@Database(
    entities = [
        BookmarkedItemEntity::class,
        QuizRecordEntity::class,
        StudyNoteEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class StudyDatabase : RoomDatabase() {
    abstract fun studyDao(): StudyDao

    companion object {
        @Volatile
        private var INSTANCE: StudyDatabase? = null

        fun getDatabase(context: Context): StudyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudyDatabase::class.java,
                    "igcse_alevel_study.db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
