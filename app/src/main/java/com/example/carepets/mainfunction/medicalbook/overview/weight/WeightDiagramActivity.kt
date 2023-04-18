package com.example.carepets.mainfunction.medicalbook.overview.weight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.children
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carepets.R
import com.example.carepets.database.PetWeight
import com.example.carepets.database.PetWeightRepository
import com.example.carepets.databinding.ActivityWeightDiagramBinding
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context

class WeightDiagramActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeightDiagramBinding
    private lateinit var res: PetWeightRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeightDiagramBinding.inflate(layoutInflater)
        setContentView(binding.root)

        res = PetWeightRepository(application)

    }
    private fun displayList(wlist: List<PetWeight>) {
        val adapter = WeightListAdapter(wlist)
        binding.rvWeight.adapter = adapter
        binding.rvWeight.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
//        binding.rvWeight
    }
}