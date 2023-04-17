package com.example.carepets.mainfunction

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.carepets.mainfunction.home.HomeFragment
import com.example.carepets.mainfunction.medicalbook.MedicalBookFragment
import com.example.carepets.mainfunction.medicalbook.note.NoteFragment
import com.example.carepets.mainfunction.medicalbook.overview.OverViewFragment
import com.example.carepets.mainfunction.reminder.ReminderFragment

class ViewPagerAdapter(fm: FragmentManager, behavior: Int) : FragmentStatePagerAdapter(fm, behavior) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> MedicalBookFragment()
            else -> ReminderFragment()
        }
    }
}