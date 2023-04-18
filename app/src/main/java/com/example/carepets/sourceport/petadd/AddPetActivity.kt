package com.example.carepets.sourceport.petadd

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import com.example.carepets.R
import com.example.carepets.database.PetRepository
import com.example.carepets.databinding.ActivityAddPetBinding
import com.example.carepets.mainfunction.TrackerActivity

class AddPetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddPetBinding
    private lateinit var res: PetRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        res = PetRepository(application)

        binding.btnPickImg.setOnClickListener {
            pickImg()
        }
        var name = binding.editName.text.toString()
        var species = binding.editSpecies.text.toString()
        var birth: String = ""

        binding.editBirth.setOnClickListener {view: View ->
            birth = takeDate(view)
        }
        binding.btnSubmit.setOnClickListener {

        }

    }
    private fun takeDate(view: View): String {
        var calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, year, month, day ->
            binding.editBirth.text = "$day/${month+1}/$year"
        }, year, month, day)
            .show()
        return "$day/${month+1}/$year"
    }
    private fun pickImg() {
        var i: Intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(i, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_OK && data != null) {
            var selectedImgUri: Uri? = data.data
            binding.imgPet.setImageURI(selectedImgUri)
//            if (selectedImgUri != null) {
//                uri = selectedImgUri
//                var inputStream: InputStream? = contentResolver.openInputStream(uri)
//                bmp = BitmapFactory.decodeStream(inputStream)
//            }
        }
    }
    fun reDirect() {
        var i: Intent = Intent()
        i.setClass(this, TrackerActivity::class.java)
        startActivity(i)
    }
}