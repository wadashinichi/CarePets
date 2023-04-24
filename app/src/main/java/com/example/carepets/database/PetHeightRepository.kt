package com.example.carepets.database

import android.app.Application

class PetHeightRepository(var application: Application) {
    private lateinit var db: PetDatabase

    init {
        db = PetDatabase.getInstance(application)
    }

    fun insert(height: PetHeight) = db.heightDao().insertHeight(height)

    fun getAll(): List<PetHeight> = db.heightDao().getAll()

    fun getHeightById(id: Int): List<PetHeight> = db.heightDao().getHeightById(id)


}