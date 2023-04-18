package com.example.carepets.mainfunction.reminder

import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carepets.R
import com.example.carepets.databinding.FragmentReminderBinding


class ReminderFragment : Fragment() {

    private lateinit var binding: FragmentReminderBinding
//    private lateinit var
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReminderBinding.inflate(layoutInflater)
//        binding.switchWalk.cha
        if (binding.switchWalk.isChecked) {
//            if (binding.tvWalk.text == "") {
//                binding.tvWalk.text = takeTime()
//            } else {
////                Dat thong bao cho dien thoai
//            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }
    private fun takeTime(view: View): String {
        val clock = Calendar.getInstance()
        var hour = clock.get(Calendar.HOUR)
        var minute = clock.get(Calendar.MINUTE)
        TimePickerDialog(requireContext(), TimePickerDialog.OnTimeSetListener { view, hour, minute ->
            binding.tvWalk.text = "$hour:$minute"
        }, hour, minute, true)
            .show()
        return "$hour:$minute"
    }
}