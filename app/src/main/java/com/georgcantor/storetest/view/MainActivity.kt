package com.georgcantor.storetest.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.georgcantor.storetest.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView = findViewById(R.id.navigation)

        navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_front -> {
                    Navigation.findNavController(this, R.id.navHostFragment)
                        .navigate(R.id.storeFragment)
                }
                R.id.nav_back -> {
                }
            }
            true
        }
    }

}
