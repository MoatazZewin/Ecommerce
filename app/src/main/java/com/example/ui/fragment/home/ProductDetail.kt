package com.example.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerce.databinding.FragmentProductDetailBinding
import com.example.ui.adapter.PagerAdapter
import com.example.ui.viewmodel.BrandViewModel


class ProductDetail : Fragment() {

    private lateinit var binding:FragmentProductDetailBinding
    private lateinit var brandViewModel: BrandViewModel
    private lateinit var pagerAdapter: PagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentProductDetailBinding.inflate(inflater)
        brandViewModel=ViewModelProvider(requireActivity())[BrandViewModel::class.java]
        pagerAdapter= PagerAdapter(requireContext())
        brandViewModel.liveDataproductDetail.observe(requireActivity(),{

            pagerAdapter.setContentList(it.product!!.images)
            binding.viewPagerMain.adapter=pagerAdapter
            binding.qty.text=it.product!!.bodyHtml
            binding.productTitle.text=it.product!!.title
            binding.vendorEditable.text=it.product!!.vendor
            binding.stateEditable.text=it.product?.status
            binding.progressPar.visibility=View.GONE
            binding.prise.text=it.product!!.variants[0].price
//            binding.viewPagerMain.adapter=pagerAdapter



        })
        return binding.root
    }

}