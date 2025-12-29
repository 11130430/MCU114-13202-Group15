package com.example.project.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FeedbackDao {
    @Insert
    suspend fun insertFeedback(feedback: Feedback)

    @Query("SELECT * FROM feedbacks ORDER BY id DESC")
    suspend fun getAllFeedbacks(): List<Feedback>
}