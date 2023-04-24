package com.example.carepets.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "height_table")
data class PetHeight (
    @PrimaryKey(autoGenerate = true)
    var heightId: Int? = 0,

    @ColumnInfo(name = "pet_id")
    var petId: Int = 0,

    @ColumnInfo(name = "height_date")
    var heightDate: String = "",

    @ColumnInfo(name = "height_time")
    var heightTime: String = "",

    @ColumnInfo(name = "height_result")
    var heightResult: Double = 0.0
)