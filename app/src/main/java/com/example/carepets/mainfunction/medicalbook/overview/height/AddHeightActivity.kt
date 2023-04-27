package com.example.carepets.mainfunction.medicalbook.overview.height

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.carepets.R
import com.example.carepets.database.PetHeight
import com.example.carepets.database.PetHeightRepository

class AddHeightActivity : AppCompatActivity() {

    private lateinit var res: PetHeightRepository
    private var id: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_weight)

        res = PetHeightRepository(application)
        val toolbar: Toolbar = findViewById(R.id.tool_bar)
        toolbar.title = "Add Pet's Height"

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent: Intent = intent
        id = intent.getIntExtra("petId", 1)
        var date: String = ""
        var time: String = ""
        var result: Double = 0.0

        val tvDate: TextView = findViewById(R.id.tv_date)
        tvDate.setOnClickListener {view: View ->
            takeDate(view)
        }
        val tvTime: TextView = findViewById(R.id.tv_time)
        tvTime.setOnClickListener {view: View ->
            takeTime(view)
        }
        val btnSubmit: Button = findViewById(R.id.btn_submit)
        btnSubmit.setOnClickListener {
            val editDate: TextView = findViewById(R.id.edit_date)
            val editHeight: TextView = findViewById(R.id.edit_weight)
            val editTime: TextView = findViewById(R.id.edit_time)
            result = editHeight.text.toString().toDouble()
            date = editDate.text.toString()
            time = editTime.text.toString()

            var height: PetHeight = PetHeight(null, id, date, time, result)
            res.insert(height)

            reDirect()
        }
    }
    private fun takeDate(view: View){
        var calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)
        val editDate: TextView = findViewById(R.id.edit_date)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, year, month, day ->
            editDate.text = "$day/${month + 1}/$year"
        }, year, month, day)
            .show()
    }
    private fun takeTime(view: View) {
        val clock = Calendar.getInstance()
        var hour = clock.get(Calendar.HOUR)
        var minute = clock.get(Calendar.MINUTE)
        val editTime: TextView = findViewById(R.id.edit_time)
        TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hour, minute ->
            editTime.text = "$hour:$minute"
        }, hour, minute, true)
            .show()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                reDirect()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    fun reDirect() {
        var i: Intent = Intent(this, HeightDiagramActivity::class.java)
        i.putExtra("petId", id)
        startActivity(i)
    }
}