package com.example.carepets.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weight_table")
data class PetWeight (
    @PrimaryKey(autoGenerate = true)
    var weightId: Int? = 0,

    @ColumnInfo(name = "pet_id")
    var petId: Int = 0,

    @ColumnInfo(name = "weight_date")
    var weightDate: String = "",

    @ColumnInfo(name = "weight_time")
    var weightTime: String = "",

    @ColumnInfo(name = "weight_result")
    var weightResult: Float = 0F
)