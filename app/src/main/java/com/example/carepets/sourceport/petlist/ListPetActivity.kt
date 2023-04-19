package com.example.carepets.sourceport.petlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carepets.R
import com.example.carepets.database.Pet
import com.example.carepets.database.PetRepository
import com.example.carepets.databinding.ActivityListPetBinding
import com.example.carepets.sourceport.petadd.AddPetActivity

class ListPetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListPetBinding
    private lateinit var res: PetRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListPetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        res = PetRepository(application)
        var plist: List<Pet> = res.getAll()
        displayList(plist)

        binding.btnAdd.setOnClickListener {
            var i: Intent = Intent()
            i.setClass(this, AddPetActivity::class.java)
            startActivity(i)
        }
    }
    fun displayList(plist: List<Pet>) {
        val adapter = PetListAdapter(plist, this)
        binding.rvPetList.adapter = adapter
        binding.rvPetList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        var decorate: RecyclerView.ItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.rvPetList.addItemDecoration(decorate)
    }
}