package com.example.carepets.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.sql.Blob

@Entity(tableName = "pet_table")
data class Pet(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,

    @ColumnInfo(name = "pet_name")
    var name: String = "",

    @ColumnInfo(name = "pet_img")
    var img: String,

    @ColumnInfo(name = "pet_birth")
    var birth: String = "",

    @ColumnInfo(name = "pet_species")
    var species: String = ""
) : Serializable