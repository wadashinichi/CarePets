package com.example.carepets.mainfunction.medicalbook.overview

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carepets.R
import com.example.carepets.databinding.FragmentOverViewBinding
import com.example.carepets.mainfunction.TrackerActivity
import com.example.carepets.mainfunction.medicalbook.overview.height.HeightDiagramActivity
import com.example.carepets.mainfunction.medicalbook.overview.weight.AddWeightActivity
import com.example.carepets.mainfunction.medicalbook.overview.weight.WeightDiagramActivity

class OverViewFragment : Fragment() {

    lateinit var binding: FragmentOverViewBinding
    lateinit var trackerActivity: TrackerActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverViewBinding.inflate(layoutInflater)
        trackerActivity = activity as TrackerActivity
        var id = trackerActivity.getPetId()


        binding.cardView1.setOnClickListener {
            val i: Intent = Intent(requireContext(), WeightDiagramActivity::class.java)
            i.putExtra("petId", id)
            startActivity(i)
        }
        binding.cardView2.setOnClickListener {
            val i: Intent = Intent(requireContext(), HeightDiagramActivity::class.java)
            i.putExtra("petId", id)
            startActivity(i)
        }
        return binding.root
    }

}
