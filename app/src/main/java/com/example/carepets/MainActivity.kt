package com.example.carepets

/*dieu phoi cac fragment*/

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.ui.NavigationUI
import com.example.carepets.databinding.ActivityMainBinding
import com.example.carepets.mainfunction.home.HomeFragment
import com.example.carepets.mainfunction.medicalbook.MedicalBookFragment
import com.example.carepets.mainfunction.reminder.ReminderFragment
import com.example.carepets.sourceport.aboutus.AboutFragment
import com.example.carepets.sourceport.petlist.ListPetFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
//        NavigationUI.setupWithNavController(binding.navView, navController)

        setSupportActionBar(binding.toolBar)
        var toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolBar, R.string.drawer_open, R.string.drawer_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        // bat su kien khi kich vao item
        binding.navigationView.setNavigationItemSelectedListener(this)
        replaceFragment(HomeFragment())
        binding.bottomNavigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener() {item: MenuItem ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.medicalBookFragment -> {
                    replaceFragment(MedicalBookFragment())
                    true
                }
                else -> {
                    replaceFragment(ReminderFragment())
                    true
                }
            }
            
        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var id: Int = item.itemId
//         xu ly khi la chinh no
        when (id) {
            R.id.listPetFragment -> replaceFragment(ListPetFragment())
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
}