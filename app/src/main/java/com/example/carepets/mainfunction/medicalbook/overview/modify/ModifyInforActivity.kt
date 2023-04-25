package com.example.carepets.mainfunction.medicalbook.overview.modify

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import com.example.carepets.R
import com.example.carepets.database.Pet
import com.example.carepets.database.PetRepository
import com.example.carepets.mainfunction.TrackerActivity

class ModifyInforActivity : AppCompatActivity() {

    private lateinit var res: PetRepository
    private lateinit var editBirth: TextView
    private lateinit var uri: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pet)

        res = PetRepository(application)
        val intent: Intent = intent
        val id = intent.getIntExtra("petId", 1)
        val pet: Pet = res.getById(id)

        var name = ""
        var birth = ""
        var species = ""
        var img = ""
        val editName: EditText = findViewById(R.id.editName)
        editBirth = findViewById(R.id.editBirth)
        val editSpecies: EditText = findViewById(R.id.editSpecies)
        editName.setText(pet.name)
        editBirth.text = pet.birth
        editSpecies.setText(pet.species)

        // image
        var image: ImageView = findViewById(R.id.imgPet)
        image.setImageURI(pet.name.toUri())
        val pickBtn: ImageButton = findViewById(R.id.btn_pickImg)
        pickBtn.setOnClickListener {
            pickImg()
            img = uri
        }

        editBirth.setOnClickListener { view: View ->
            takeDate(view)
        }

        val btnSave: Button = findViewById(R.id.btnSubmit)
        btnSave.setOnClickListener {
            name = editName.text.toString()
            birth = editBirth.text.toString()
            species = editSpecies.text.toString()
            res.update(name, "", birth, species, id)
            var i: Intent = Intent(this, TrackerActivity::class.java)
            i.putExtra("petId", id)
            startActivity(i)
        }

    }
    private fun takeDate(view: View){
        var calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)
        var date: String = ""
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, year, month, day ->
            editBirth.text = "$day/${month+1}/$year"
        }, year, month, day)
            .show()
    }
    private fun pickImg() {
        var i: Intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(i, 3)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var img: ImageView = findViewById(R.id.imgPet)

        if (resultCode == RESULT_OK && data != null) {
            var selectedImg: Uri? = data.data
            img.setImageURI(selectedImg)

            if (selectedImg != null) {
                uri = selectedImg.toString()
            }

        }
    }
}