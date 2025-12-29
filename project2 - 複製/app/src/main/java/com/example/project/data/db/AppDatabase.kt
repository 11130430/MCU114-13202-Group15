package com.example.project.data.db // 假設你改名為 db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.project.data.Attraction
import com.example.project.data.AttractionDao
import com.example.project.data.Feedback // 根據你 Feedback.kt 的位置調整
import com.example.project.data.FeedbackDao

@Database(entities = [Attraction::class, Feedback::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun attractionDao(): AttractionDao
    abstract fun feedbackDao(): FeedbackDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}