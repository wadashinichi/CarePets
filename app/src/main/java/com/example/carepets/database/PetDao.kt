package com.example.carepets.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PetDao {

    @Insert
    fun insertPetFull(pet: Pet)

    @Query("SELECT COUNT (id) FROM pet_table")
    fun getPetCount(): Int

    @Query("SELECT * FROM pet_table")
    fun getAll(): List<Pet>

    @Query ("SELECT * FROM pet_table WHERE id = :id")
    fun getPetById(id: Int): Pet

    @Query("DELETE FROM pet_table")
    fun delAll()

    @Query("UPDATE pet_table SET pet_name = :name," +
            "pet_img = :img, " +
            "pet_birth = :birth, " +
            "pet_species = :species WHERE id = :id")
    fun updatePet(name: String, img: String, birth: String, species: String, id: Int)

}