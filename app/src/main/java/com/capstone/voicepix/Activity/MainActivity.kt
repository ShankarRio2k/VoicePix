package com.capstone.voicepix.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.capstone.voicepix.R
import com.capstone.voicepix.databinding.ActivityMainBinding
import com.capstone.voicepix.fragments.HomeFragment
import com.capstone.voicepix.fragments.IdeaFragment
import com.capstone.voicepix.fragments.ProfileFragment
import com.capstone.voicepix.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomNavigationView = binding.bottomNav

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Home -> {
                    loadFragment(HomeFragment())
                }
                R.id.Transact -> {
                    loadFragment(IdeaFragment())
                }
                R.id.saveorbarrow -> {
                    loadFragment(SettingsFragment())
                }
                R.id.others -> {
                    loadFragment(ProfileFragment())
                }
            }
            true
        }
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}