package com.example.carepets.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PetHeightDao {

    @Insert
    fun insertHeight(height: PetHeight)

    @Query("SELECT COUNT (heightId) FROM height_table")
    fun getHeightCount(): Int

    @Query("SELECT * FROM height_table")
    fun getAll(): List<PetHeight>

    @Query("SELECT * FROM height_table WHERE pet_id = :id")
    fun getHeightById(id: Int): List<PetHeight>

}