package com.example.carepets.mainfunction.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import com.example.carepets.R
import com.example.carepets.database.Pet
import com.example.carepets.database.PetRepository
import com.example.carepets.databinding.FragmentHomeBinding
import com.example.carepets.mainfunction.TrackerActivity
import com.example.carepets.mainfunction.medicalbook.overview.modify.ModifyInforActivity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var res: PetRepository
    private lateinit var trackerActivity: TrackerActivity
    private var id: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        res = PetRepository(requireActivity().application)
        trackerActivity = activity as TrackerActivity
        id = trackerActivity.getPetId()
        var pet: Pet = res.getById(id)
        binding.petName.text = pet.name
        binding.speciesText.text = "Species: ${pet.species}"
        binding.ageText.text = "Age: Unknown"
        binding.weightText.text = "Weight: Unknown"
        binding.heightText.text = "Height: Unknown"
        binding.lengthText.text = "Length: Unknown"
        binding.heartText.text = "Heart beat: Unknown"

        // image
        var img: String = ""
        img = pet.img
        var uri: Uri = img.toUri()

        if (uri != null) {
            assignImg(uri)
        }
        binding.editBtn.setOnClickListener {
            var i: Intent = Intent(requireContext(), ModifyInforActivity::class.java)
            i.putExtra("petId", pet.id)
            startActivity(i)
        }
        return binding.root
    }

    private fun assignImg(uri: Uri) {
        var img: ImageView = binding.imgPet
        img.setImageURI(uri)
    }


}