package com.example.carepets.sourceport.petlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carepets.R
import com.example.carepets.database.PetRepository

class DelItemActivity : AppCompatActivity() {

    private lateinit var res: PetRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        res = PetRepository(application)

        var intent: Intent = intent
        var id: Int = intent.getIntExtra("petId", 1)
        res.delById(id)
        reDirect()
    }
    fun reDirect() {
        var i: Intent = Intent()
        i.setClass(this, ListPetActivity::class.java)
        startActivity(i)
    }
}