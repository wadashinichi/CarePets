package com.example.carepets.mainfunction.medicalbook.overview.height

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.carepets.R

class HeightDiagramActivity : AppCompatActivity() {

    lateinit var binding: HeightDiagramActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight_diagram)

        val toolbar: Toolbar = findViewById(R.id.tool_bar)
        toolbar.title = "Add Pet's Height"

    }
}