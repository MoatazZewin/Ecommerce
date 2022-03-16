package com.example.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.ecommerce.HomeFragment
import com.example.ecommerce.R
import com.example.model.dataClass.productdetail.Product
import com.example.ui.adapter.SliderAdapter
import com.example.ui.fragment.category.CategoryFragment
import com.example.ui.fragment.home.AddtoCard
import com.example.ui.fragment.profile.MeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), AddtoCard {
    lateinit var bottomNagationView: BottomNavigationView
    lateinit var homeFragment: HomeFragment
    lateinit var meFragment: MeFragment
    lateinit var categoryFragment: CategoryFragment
//    var products: ArrayList<Product> = ArrayList<Product>()
//    var images: Array<Int> = arrayOf(R.drawable.sale1, R.drawable.sale2, R.drawable.sale3)
//    var adapter: SliderAdapter = SliderAdapter(applicationContext, images)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNagationView = findViewById(R.id.bottom_navigation)
        homeFragment = HomeFragment()
        meFragment = MeFragment()
        categoryFragment = CategoryFragment()
//        viewpager.adapter=adapter

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment)
            .commit()
        bottomNagationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.shopTabFragment2 -> replaceFragment(homeFragment)
                R.id.categoryFragment -> replaceFragment(categoryFragment)
                R.id.meFragment -> replaceFragment(meFragment)
            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()

        }
    }

//    @JvmName("getProducts1")
//    public fun getProducts(): ArrayList<Product> {
//        return products
//    }
//
//    override fun addtoCard(product: Product) {
//        super.addtoCard(product)
//        products.add(product)
//        Log.d("TAG", "addtoCard: " + product.title)
//    }
}