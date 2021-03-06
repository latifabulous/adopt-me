package com.example.adoptme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.adoptme.fragments.BagFragment
import com.example.adoptme.fragments.HomeFragment
import com.example.adoptme.fragments.ProfileFragment
import com.example.adoptme.fragments.StoreFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val storeFragment = StoreFragment()
        val bagFragment = BagFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)

        val bottomNavigation : com.google.android.material.bottomnavigation.BottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_store -> makeCurrentFragment(storeFragment)
                R.id.ic_bag -> makeCurrentFragment(bagFragment)
                R.id.ic_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment : Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}