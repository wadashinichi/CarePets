package com.example.carepets.mainfunction.medicalbook.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carepets.R
import com.example.carepets.databinding.FragmentOverViewBinding

class OverViewFragment : Fragment() {

    lateinit var binding: FragmentOverViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverViewBinding.inflate(layoutInflater)

        // Inflate the layout for this fragment
        return binding.root
    }

}