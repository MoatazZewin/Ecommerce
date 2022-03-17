package com.example.ui.fragment.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerce.R
import com.example.ecommerce.SearchFragment
import com.example.ecommerce.databinding.FragmentCBinding
import com.example.ui.SettingFragment
import com.example.ui.fragment.chart.CartFragment
import com.example.ui.fragment.favorite.FavoriteFragment
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems


class CategoryFragment : Fragment() {
    lateinit var favFragment: FavoriteFragment
    lateinit var binding:FragmentCBinding
    lateinit var cartFragment:CartFragment
    lateinit var settingFragment: SettingFragment
    lateinit var searchFragment : SearchFragment


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCBinding.inflate(inflater, container, false)
        setUpTabs()
        click()
        return binding.root
    }

    private fun setUpTabs(){
        val adapter = FragmentPagerItemAdapter(
            childFragmentManager,
            FragmentPagerItems.with(activity)
                .add("Men", ManFragment::class.java)
                .add("Women", WomanFragment::class.java)
                .add("Kids", KidFragment::class.java)
                .add("OnSale", SaleFragment::class.java)
                .create()
        )
        binding.viewpager2.adapter = adapter
        binding.smartTabs.setViewPager(binding.viewpager2)
    }

    fun click(){
        binding.toFav.setOnClickListener {
            favFragment= FavoriteFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, favFragment)?.commit()
        }
        binding.toCart.setOnClickListener {
            cartFragment = CartFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, cartFragment)?.commit()
        }
        binding.toSettings.setOnClickListener {
            settingFragment = SettingFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, settingFragment)?.commit()
        }
        binding.leftIconLogin.setOnClickListener {
            searchFragment = SearchFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, searchFragment)?.commit()
        }
    }
    }

