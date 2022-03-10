package com.example.ecommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNagationView:BottomNavigationView
    lateinit var homeFragment :HomeFragment
    lateinit var meFragment :MeFragment
    lateinit var categoryFragment :CategoryFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNagationView = findViewById(R.id.bottom_navigation)
        homeFragment = HomeFragment()
        meFragment = MeFragment()
        categoryFragment = CategoryFragment()
       supportFragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment).commit()
        bottomNagationView.setOnItemSelectedListener {
            when (it.itemId)
            {
                R.id.shopTabFragment2 -> replaceFragment(homeFragment)
                R.id.categoryFragment -> replaceFragment(categoryFragment)
                R.id.meFragment -> replaceFragment(meFragment)
            }
            true
        }


    }
    private fun replaceFragment(fragment:Fragment)
    {
        if (fragment != null)
        {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()

        }
    }
}