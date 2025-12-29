package com.example.project.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// ✅ 1. 確保 entities 包含 Feedback::class
@Database(entities = [Attraction::class, Feedback::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun attractionDao(): AttractionDao

    // ✅ 2. 加入這行抽象方法，Fragment 才能使用 .feedbackDao()
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
                    .fallbackToDestructiveMigration() // 結構改變時自動重洗表格
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}