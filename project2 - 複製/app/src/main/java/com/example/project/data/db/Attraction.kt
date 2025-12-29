// 如果你把資料夾改名為 model
package com.example.project.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "planned_attractions")
data class Attraction(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        val name: String,
        val location: String,
        val imageUrl: String,
        val description: String,
        val userId: String = "",
        val latitude: Double = 0.0,
        val longitude: Double = 0.0
) : Parcelable