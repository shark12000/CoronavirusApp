package com.example.coronaway.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.coronaway.R
import com.example.coronaway.view.fragments.InfoViewModel
import com.example.coronaway.view.fragments.dashboard.DashboardFragment
import com.example.coronaway.view.fragments.map.MapsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: InfoViewModel by viewModels()
    private val dashboardFragment = DashboardFragment()
    private val mapsFragment = MapsFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(mapsFragment)

        val nav: BottomNavigationView = findViewById(R.id.bottom_navigation)

        nav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.item1 -> replaceFragment(dashboardFragment)
                R.id.item2 -> replaceFragment(mapsFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}