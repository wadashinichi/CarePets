package com.example.carepets.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PetDao {

    @Insert
    fun insertPetFull(pet: Pet)

//    @Query("INSERT INTO pet_table(\"pet_name\", \"pet_img\", \"pet_birth\", \"pet_species\") VALUES (:name, :img, :birth, :species)")
//    fun insertPet(name: String, img: Int, birth: String, species: String)

    @Query("SELECT COUNT (id) FROM pet_table")
    fun getPetCount(): Int

    @Query("SELECT * FROM pet_table")
    fun getAll(): List<Pet>

    @Query ("SELECT * FROM pet_table WHERE id = :id")
    fun getPetById(id: Int): Pet

    @Query("DELETE FROM pet_table")
    fun delAll()

}