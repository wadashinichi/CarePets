package com.example.carepets.mainfunction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.carepets.R
import com.example.carepets.databinding.ActivityTrackerBinding
import com.example.carepets.mainfunction.home.HomeFragment
import com.example.carepets.mainfunction.medicalbook.MedicalBookFragment
import com.example.carepets.mainfunction.reminder.ReminderFragment
import com.example.carepets.sourceport.aboutus.AboutFragment
import com.example.carepets.sourceport.petlist.ListPetActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

/*dieu phoi cac fragment*/
//contant_frame: frameLayout -> viewpager

class TrackerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityTrackerBinding
    private var id: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent: Intent = intent
        id = intent.getIntExtra("petId", 1)

        setSupportActionBar(binding.toolBar)
        var toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolBar, R.string.drawer_open, R.string.drawer_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        // bat su kien khi kich vao item
        binding.navigationView.setNavigationItemSelectedListener(this)

        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
//        binding.contentFrame.adapter = adapter

//        binding.contentFrame.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//
//            }
//
//            override fun onPageSelected(position: Int) {
//                when (position) {
//                    0 -> binding.bottomNavigation.menu.findItem(R.id.homeFragment).isChecked = true
//                    1 -> binding.bottomNavigation.menu.findItem(R.id.medicalBookFragment).isChecked = true
//                    2 -> binding.bottomNavigation.menu.findItem(R.id.reminderFragment).isChecked = true
//                }
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {
//
//            }
//
//
//        })

        replaceFragment(HomeFragment())
//        binding.contentFrame.currentItem = 0
        binding.bottomNavigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener() { item: MenuItem ->
            when (item.itemId) {
                R.id.homeFragment -> {
//                    binding.contentFrame.currentItem = 0
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.medicalBookFragment -> {
                    replaceFragment(MedicalBookFragment())
//                    binding.contentFrame.currentItem = 1
                    true
                }
                else -> {
                    replaceFragment(ReminderFragment())
//                    binding.contentFrame.currentItem = 2
                    true
                }
            }
//            true

        })

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var id: Int = item.itemId
//         xu ly khi la chinh no
        when (id) {
            R.id.listPetFragment -> {
//                replaceFragment(ListPetFragment())
                var i: Intent = Intent()
                i.setClass(this, ListPetActivity::class.java)
                startActivity(i)
            }
            R.id.aboutFragment -> replaceFragment(AboutFragment())
        }
        binding.navigationView.setCheckedItem(id)
//        setTitle(id)
//        binding.navigationView.menu.findItem(id).isChecked = true
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    // thuc hien khi nhan nut back
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }
    private fun replaceFragment(fg: Fragment) {
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_frame, fg)
        transaction.commit()
    }
    private fun setTitleToolBar(id: Int) {
        var title = when (id) {
            R.id.listPetFragment -> "List Pets"
            else -> "About Us"
        }
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }
    fun getPetId(): Int {
        return id
    }

}