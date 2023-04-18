package com.example.carepets.sourceport.petlist

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carepets.MainActivity
import com.example.carepets.R
import com.example.carepets.database.Pet
import com.example.carepets.database.PetRepository
import com.example.carepets.databinding.ActivityListPetBinding
import com.example.carepets.databinding.FragmentListPetBinding
import com.example.carepets.sourceport.petadd.AddPetActivity

class ListPetFragment : Fragment() {

    private lateinit var binding: FragmentListPetBinding
    private lateinit var res: PetRepository
//    private lateinit var

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListPetBinding.inflate(layoutInflater)
        res = PetRepository(requireActivity().application)

        var plist: List<Pet> = res.getAll()
        displayList(plist)

        binding.btnAdd.setOnClickListener {
            var i: Intent = Intent()
            i.setClass(requireContext(), AddPetActivity::class.java)
            startActivity(i)
        }

        return binding.root
    }

    fun displayList(plist: List<Pet>) {
        val adapter = PetListAdapter(plist)
        binding.rvPetList.adapter = adapter
        binding.rvPetList.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
    }

}