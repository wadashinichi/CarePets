package com.example.carepets


import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.navigation.ui.NavigationUI
import androidx.viewpager.widget.ViewPager
import com.example.carepets.database.PetRepository
import com.example.carepets.databinding.ActivityMainBinding
import com.example.carepets.mainfunction.ViewPagerAdapter
import com.example.carepets.mainfunction.home.HomeFragment
import com.example.carepets.mainfunction.medicalbook.MedicalBookFragment
import com.example.carepets.mainfunction.reminder.ReminderFragment
import com.example.carepets.sourceport.aboutus.AboutFragment
import com.example.carepets.sourceport.petlist.ListPetFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var res: PetRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        res = PetRepository(application)
        var i: Intent = Intent()
//        var count: Int = res.getCount()
//        if (count == 0) {
//            i.setClass(this, )
//        }
        i.setClass(this, ListPetFragment::class.java)
    }


}