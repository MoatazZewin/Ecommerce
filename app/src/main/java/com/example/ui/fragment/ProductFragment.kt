package com.example.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerce.HomeFragment
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentProductBinding
import com.example.ui.adapter.ProductsAdapter
import com.example.ui.viewmodel.BrandViewModel


class ProductFragment : Fragment(),ProductsAdapter.OnBrandClickListner {

    private lateinit var binding:FragmentProductBinding
    private lateinit var brandViewModel: BrandViewModel
    private lateinit var productsAdapter: ProductsAdapter
    lateinit var homeFragment: HomeFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentProductBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        brandViewModel=ViewModelProvider(requireActivity())[BrandViewModel::class.java]
        brandViewModel.liveDataAllProducts.observe(requireActivity(),{
            productsAdapter= ProductsAdapter(requireContext(),this)
            productsAdapter.addList(it.products)
            binding.productRecycler.adapter=productsAdapter
        })
    }

    override fun onPause() {
        super.onPause()
        productsAdapter.addList(emptyList())
        homeFragment = HomeFragment()
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, homeFragment)?.commit()

    }




}