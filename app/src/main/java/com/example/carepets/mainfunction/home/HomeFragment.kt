package com.example.carepets.mainfunction.home

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

        // image
        var img: String = ""
        img = pet.img
        var uri: Uri = img.toUri()

        if (uri != null) {
            assignImg(uri)
        }
        return binding.root
    }

    private fun assignImg(uri: Uri) {
        var img: ImageView = binding.imgPet
        img.setImageURI(uri)
    }


}