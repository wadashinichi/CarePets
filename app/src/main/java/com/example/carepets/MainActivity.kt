package com.example.carepets


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import com.example.carepets.database.PetRepository
import com.example.carepets.databinding.ActivityMainBinding
import com.example.carepets.sourceport.petlist.ListPetActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var res: PetRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        res = PetRepository(application)
        Handler(Looper.getMainLooper()).postDelayed({
            var i: Intent = Intent()
            i.setClass(this, ListPetActivity::class.java)
            startActivity(i)
        }, 2000)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainpart, fragment)
        fragmentTransaction.commit()
    }

}