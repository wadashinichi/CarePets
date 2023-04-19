package com.example.carepets.database

import android.app.Application

class PetWeightRepository(var application: Application) {
    private lateinit var db: PetDatabase
    init {
        db = PetDatabase.getInstance(application)
    }

    fun insert(weight: PetWeight) = db.weightDao().insertWeight(weight)
    fun getAll(): List<PetWeight> = db.weightDao().getAll()
    fun getWeightById(id: Int): List<PetWeight> = db.weightDao().getWeightById(id)

}