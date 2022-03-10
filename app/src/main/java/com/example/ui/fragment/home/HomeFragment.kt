package com.example.ecommerce

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerce.databinding.CategaryItemBinding
import com.example.ecommerce.databinding.FragmentHomeBinding
import com.example.model.dataClass.brand.SmartCollections
import com.example.ui.adapter.AdapterBrand
import com.example.ui.fragment.ProductFragment
import com.example.ui.viewmodel.BrandViewModel

class HomeFragment : Fragment(),AdapterBrand.OnBrandClickListner {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var brandViewModel: BrandViewModel
    private lateinit var adapterBrand: AdapterBrand
    lateinit var proudectFragment :ProductFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        brandViewModel=ViewModelProvider(requireActivity())[BrandViewModel::class.java]
        brandViewModel.liveDataResponse.observe(requireActivity(),{
            adapterBrand= AdapterBrand(requireContext(),this)
            adapterBrand.addList(it.smartCollections)
            binding.recyclerBrand.adapter=adapterBrand


        })

    }


    override fun onBrandClick(smartCollections: SmartCollections, position: Int) {
        brandViewModel.getProducts(smartCollections.id!!)
        proudectFragment = ProductFragment()
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, proudectFragment)?.commit()



    }


}