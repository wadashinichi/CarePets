package com.example.carepets.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.lang.annotation.Inherited

@Dao
interface PetWeightDao {

    @Insert
    fun insertWeight(weight: PetWeight)

    @Query("SELECT COUNT (weightId) FROM weight_table")
    fun getWeightCount(): Int

    @Query("SELECT * FROM weight_table")
    fun getAll(): List<PetWeight>

}