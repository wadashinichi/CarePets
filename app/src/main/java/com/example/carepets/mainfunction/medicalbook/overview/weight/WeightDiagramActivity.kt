package com.example.carepets.mainfunction.medicalbook.overview.weight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.children
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        val intent: Intent = intent
        val id = intent.getIntExtra("petId", 1)

        val wlist: List<PetWeight> = res.getWeightById(id)
        displayList(wlist)

        binding.btnAdd.setOnClickListener {
            val i = Intent(this, AddWeightActivity::class.java)
            intent.putExtra("petId", id)
            startActivity(i)
        }

    }
    private fun displayList(wlist: List<PetWeight>) {
        val adapter = WeightListAdapter(wlist)
        binding.rvWeight.adapter = adapter
        binding.rvWeight.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        var decorate: RecyclerView.ItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.rvWeight.addItemDecoration(decorate)
    }
}