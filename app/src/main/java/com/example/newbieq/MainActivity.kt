package com.example.newbieq

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.newbieq.ui.AddItemFragment
import com.example.newbieq.ui.wishlist.WishlistFragment
import com.example.newbieq.ui.home.HomeFragment
import com.example.newbieq.ui.item.ItemFragment
import com.example.newbieq.ui.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Load HomeFragment by default
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        // Setup BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> loadFragment(HomeFragment())  // Load HomeFragment
                R.id.nav_profile -> loadFragment(ProfileFragment())  // Load ProfileFragment
                R.id.nav_items -> loadFragment(ItemFragment())  // Load ItemFragment
                R.id.nav_add -> loadFragment(AddItemFragment())  // Load AddItemFragment
                R.id.nav_wishlist -> loadFragment(WishlistFragment())  // Load WishlistFragment
                else -> false
            }
            true
        }
    }

    // Load fragments and add them to the back stack
    private fun loadFragment(fragment: androidx.fragment.app.Fragment): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)  // Replace with the provided fragment

        // Add the transaction to the back stack so the user can navigate back
        transaction.addToBackStack(null)

        // Commit the transaction
        transaction.commit()
        return true
    }
}