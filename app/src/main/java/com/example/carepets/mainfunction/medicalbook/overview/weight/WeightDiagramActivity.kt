package com.example.carepets.mainfunction.medicalbook.overview.weight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.children
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carepets.R
import com.example.carepets.database.Pet
import com.example.carepets.database.PetWeight
import com.example.carepets.database.PetWeightRepository
import com.example.carepets.databinding.ActivityWeightDiagramBinding
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class WeightDiagramActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeightDiagramBinding
    private lateinit var res: PetWeightRepository
    private lateinit var wlist : List<PetWeight>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeightDiagramBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        res = PetWeightRepository(application)
        val intent: Intent = intent
        val id = intent.getIntExtra("petId", 1)

        wlist = res.getWeightById(id)

        displayGraph(wlist)

        displayList(wlist)

        binding.btnAdd.setOnClickListener {
            val i = Intent(this, AddWeightActivity::class.java)
            i.putExtra("petId", id)
            startActivity(i)
        }
    }
    private fun displayGraph(wlist: List<PetWeight>) {
        var list: MutableList<DataPoint> = mutableListOf<DataPoint>()
        if (wlist.isNotEmpty()) {
            if (wlist.size < 11) {
                for (x in 0..wlist.size-1) {
                    var dataPoint: DataPoint = DataPoint(x.toDouble(), wlist[x].weightResult.toDouble())
                list.add(dataPoint)
                }
            } else {
                for (x in 0 .. 10) {
                    var dataPoint: DataPoint = DataPoint(x.toDouble(), wlist[x-11].weightResult.toDouble())
                    list.add(dataPoint)
                }
            }
        }

        val arr: Array<DataPoint> = list.toTypedArray()
        val series: LineGraphSeries<DataPoint> = LineGraphSeries(arr)
        binding.weightGraph.animate()
        binding.weightGraph.viewport.isScrollable = true
        binding.weightGraph.viewport.isScalable = true
        binding.weightGraph.viewport.setScrollableY(false)
        binding.weightGraph.viewport.setScalableY(false)
        series.color = R.color.black
        binding.weightGraph.addSeries(series)
    }
    private fun displayList(wlist: List<PetWeight>) {
        val adapter = WeightListAdapter(wlist)
        binding.rvWeight.adapter = adapter
        binding.rvWeight.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        var decorate: RecyclerView.ItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.rvWeight.addItemDecoration(decorate)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}