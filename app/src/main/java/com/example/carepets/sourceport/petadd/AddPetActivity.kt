package com.example.carepets.sourceport.petadd

import android.app.DatePickerDialog
import android.app.blob.BlobHandle
import android.app.blob.BlobStoreManager
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.icu.util.Calendar
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.carepets.R
import com.example.carepets.database.Pet
import com.example.carepets.database.PetRepository
import com.example.carepets.databinding.ActivityAddPetBinding
import com.example.carepets.mainfunction.TrackerActivity
import com.example.carepets.sourceport.petlist.ListPetActivity
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.sql.Blob

@Suppress("DEPRECATION")
class AddPetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddPetBinding
    private lateinit var res: PetRepository
    private var uri: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        res = PetRepository(application)

        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var name: String = ""
        var birth: String = ""
        var species: String = ""
        var img: String = ""
        binding.btnPickImg.setOnClickListener {
            pickImg()
            img = uri
        }

        binding.editBirth.setOnClickListener {view: View ->
            takeDate(view)
        }

        binding.btnSubmit.setOnClickListener {
            name = binding.editName.text.toString()
            species = binding.editSpecies.text.toString()
            birth = binding.editBirth.text.toString()

            var pet: Pet = Pet(null, name, img, birth, species)
            res.insert(pet)
            reDirect()
        }
    }
    private fun takeDate(view: View){
        var calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)
        var date: String = ""
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, year, month, day ->
            binding.editBirth.text = "$day/${month+1}/$year"
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
    private fun reDirect() {
        val i: Intent = Intent()
        i.setClass(this, TrackerActivity::class.java)
        startActivity(i)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}