package com.example.project.data

import androidx.room.*

@Dao
interface AttractionDao {
    @Query("SELECT * FROM planned_attractions WHERE userId = :currentUserId")
    suspend fun getPlannedByUserId(currentUserId: String): List<Attraction>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttraction(attraction: Attraction)

    @Delete
    suspend fun deleteAttraction(attraction: Attraction)
}