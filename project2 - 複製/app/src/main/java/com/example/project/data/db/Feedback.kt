package com.example.project.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feedbacks")
data class Feedback(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String, // 使用者心得 [cite: 35]
    val rating: Float,   // 使用者評價 [cite: 35]
    val timestamp: Long = System.currentTimeMillis()
)