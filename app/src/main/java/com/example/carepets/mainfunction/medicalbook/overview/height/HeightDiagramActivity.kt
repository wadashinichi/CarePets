package com.example.carepets.mainfunction.medicalbook.overview.height

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carepets.R
import com.example.carepets.database.PetHeight
import com.example.carepets.database.PetHeightRepository
import com.example.carepets.mainfunction.TrackerActivity
import com.example.carepets.mainfunction.medicalbook.overview.weight.HeightListAdapter
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class HeightDiagramActivity : AppCompatActivity() {

    lateinit var res: PetHeightRepository
    lateinit var hlist: List<PetHeight>
    private var id: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight_diagram)

        val toolbar: Toolbar = findViewById(R.id.tool_bar)
        toolbar.title = "Add Pet's Height"
        val btnAdd: Button = findViewById(R.id.btn_add)


        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        res = PetHeightRepository(application)
        val intent: Intent = intent
        id = intent.getIntExtra("petId", 1)

        hlist = res.getHeightById(id)

        displayGraph(hlist)
        displayList(hlist)
        btnAdd.setOnClickListener {
            val i = Intent(this, AddHeightActivity::class.java)
            i.putExtra("petId", id)
            startActivity(i)
        }

    }
    private fun displayGraph(hlist: List<PetHeight>) {
        var list: MutableList<DataPoint> = mutableListOf<DataPoint>()
        if (hlist.isNotEmpty()) {
            if (hlist.size < 11) {
                for (x in 0..hlist.size-1) {
                    var dataPoint: DataPoint = DataPoint(x.toDouble(), hlist[x].heightResult.toDouble())
                    list.add(dataPoint)
                }
            } else {
                for (x in 0 .. 10) {
                    var dataPoint: DataPoint = DataPoint(x.toDouble(), hlist[x-11].heightResult.toDouble())
                    list.add(dataPoint)
                }
            }
        }

        val arr: Array<DataPoint> = list.toTypedArray()
        val series: LineGraphSeries<DataPoint> = LineGraphSeries(arr)
        val graphview: GraphView = findViewById(R.id.weight_graph)
        graphview.animate()
        graphview.viewport.isScrollable = false
        graphview.viewport.isScalable = false
        graphview.viewport.setScrollableY(false)
        graphview.viewport.setScalableY(true)
        series.color = R.color.black
        graphview.addSeries(series)
//        binding.weightGraph.setL
    }
    private fun displayList(hlist: List<PetHeight>) {
        val adapter = HeightListAdapter(hlist)
        val rvView: RecyclerView = findViewById(R.id.rv_weight)
        rvView.adapter = adapter
        rvView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        var decorate: RecyclerView.ItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvView.addItemDecoration(decorate)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> reDirect()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun reDirect() {
        val i = Intent(this, TrackerActivity::class.java)
        i.putExtra("petId", id)
        startActivity(i)
    }
}