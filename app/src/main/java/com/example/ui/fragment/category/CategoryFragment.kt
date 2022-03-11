package com.example.ui.fragment.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerce.databinding.FragmentCBinding
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems


class CategoryFragment : Fragment() {

    private lateinit var _binding: FragmentCBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCBinding.inflate(inflater, container, false)
        setUpTabs()
        return _binding.root
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
        _binding.viewpager2.adapter = adapter
        _binding.smartTabs.setViewPager(_binding.viewpager2)
    }

}