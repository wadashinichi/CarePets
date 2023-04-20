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
import com.example.carepets.database.PetWeight
import com.example.carepets.database.PetWeightRepository
import com.example.carepets.databinding.ActivityWeightDiagramBinding
//import com.jjoe64.graphview.series.DataPoint
//import com.jjoe64.graphview.series.LineGraphSeries

//import kotlinx.coroutines.flow.internal.NoOpContinuation.context

class WeightDiagramActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeightDiagramBinding
    private lateinit var res: PetWeightRepository

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

        val wlist: List<PetWeight> = res.getWeightById(id)
        displayList(wlist)

        binding.btnAdd.setOnClickListener {
            val i = Intent(this, AddWeightActivity::class.java)
            i.putExtra("petId", id)
            startActivity(i)
        }

//        // take data
//        var dataList: MutableList<DataPoint> = mutableListOf<DataPoint>()
//        if (wlist.size < 11) {
//            for (x in 0..wlist.size) {
//                var dataPoint: DataPoint = DataPoint(x.toDouble(), wlist[x].weightResult.toDouble())
//                dataList.add(dataPoint)
//            }
//        }
//        var dataArray: Array<DataPoint> = arrayOf()
//        dataArray = dataList.toTypedArray()
//        var series: LineGraphSeries<DataPoint> = LineGraphSeries<DataPoint>(dataArray)
//        binding.graphView.title = "Weight chart"
//        binding.graphView.titleColor = R.color.black
//        binding.graphView.addSeries(series)

        // graph


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