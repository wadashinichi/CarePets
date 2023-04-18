package com.example.carepets.mainfunction.medicalbook

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.carepets.mainfunction.medicalbook.note.NoteFragment
import com.example.carepets.mainfunction.medicalbook.overview.OverViewFragment

class SectionsPagerAdapter(fm: FragmentManager, behavior: Int) : FragmentStatePagerAdapter(fm, behavior) {

    override fun getCount(): Int {
        return  2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> OverViewFragment()
            else -> NoteFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Overview"
            else -> "Note"
        }
    }
}