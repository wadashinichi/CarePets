package com.example.carepets.database

import android.app.Application

class PetRepository(var application: Application) {
    private lateinit var db: PetDatabase
    init {
        db = PetDatabase.getInstance(application)
    }
//    fun insert(name: String, img: Int, birth: String, species: String) {
//        db.petDao().insertPet(name, img, birth, species)
//    }
    fun insert(pet: Pet) = db.petDao().insertPetFull(pet)
    fun getCount(): Int = db.petDao().getPetCount()
    fun getAll(): List<Pet> = db.petDao().getAll()
    fun getById(id: Int): Pet = db.petDao().getPetById(id)
}