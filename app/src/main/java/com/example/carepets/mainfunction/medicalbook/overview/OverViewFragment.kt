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
import com.example.carepets.mainfunction.medicalbook.overview.weight.AddWeightActivity
import com.example.carepets.mainfunction.medicalbook.overview.weight.WeightDiagramActivity

class OverViewFragment : Fragment() {

    lateinit var binding: FragmentOverViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverViewBinding.inflate(layoutInflater)
        binding.cardView1.setOnClickListener {
            val i: Intent = Intent(requireContext(), WeightDiagramActivity::class.java)
            i.putExtra("petId", id)
            startActivity(i)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}
//val i: Intent = Intent(context, TrackerActivity::class.java)
//i.putExtra("petId", id)
//startActivity(context, i, null)