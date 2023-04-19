package com.example.carepets.mainfunction.medicalbook.overview.weight

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.carepets.R
import com.example.carepets.database.PetWeight
import com.example.carepets.database.PetWeightRepository
import com.example.carepets.databinding.ActivityAddWeightBinding
import java.time.Clock

class AddWeightActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddWeightBinding
    lateinit var res: PetWeightRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddWeightBinding.inflate(layoutInflater)
        setContentView(binding.root)
        res = PetWeightRepository(application)

        val intent: Intent = intent
        var id: Int = intent.getIntExtra("petId", 1)
        var date: String = ""
        var time: String = ""
        var result: Float = 0F
        binding.editDate.setOnClickListener {view: View ->
            date = takeDate(view)
        }
        binding.editTime.setOnClickListener {view: View ->
            time = takeTime(view)
        }
        binding.btnSubmit.setOnClickListener {
            result = binding.editWeight.text.toString().toFloat()
            var weight: PetWeight = PetWeight(null, id, date, time, result)
            res.insert(weight)
            var i: Intent = Intent()
            i.setClass(this, WeightDiagramActivity::class.java)
            startActivity(i)
        }


    }
    private fun takeDate(view: View): String {
        var calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, year, month, day ->
            binding.editDate.text = "$day/${month + 1}/$year"
        }, year, month, day)
            .show()
        return "$day/${month+1}/$year"
    }
    private fun takeTime(view: View): String {
        val clock = Calendar.getInstance()
        var hour = clock.get(Calendar.HOUR)
        var minute = clock.get(Calendar.MINUTE)
        TimePickerDialog(this, TimePickerDialog.OnTimeSetListener {view, hour, minute ->
            binding.editTime.text = "$hour:$minute"
        }, hour, minute, true)
            .show()
        return "$hour:$minute"
    }
}