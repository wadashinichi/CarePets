package com.example.carepets.mainfunction.medicalbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.carepets.R
import com.example.carepets.databinding.FragmentMedicalBookBinding


class MedicalBookFragment : Fragment() {

    lateinit var binding: FragmentMedicalBookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMedicalBookBinding.inflate(layoutInflater)
        var adapter: SectionsPagerAdapter = SectionsPagerAdapter(childFragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)



        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_medical_book, container, false)
        return binding.root
    }


}