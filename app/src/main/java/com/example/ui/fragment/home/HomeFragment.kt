package com.example.ecommerce

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.SearchView
import androidx.fragment.app.Fragment
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
        brandViewModel.liveDataResponse.observe(viewLifecycleOwner,{
            adapterBrand= AdapterBrand(requireContext(),this)
            adapterBrand.addList(it.smartCollections)
            binding.recyclerBrand.adapter=adapterBrand


        })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)


    }


    override fun onBrandClick(smartCollections: SmartCollections, position: Int) {
        brandViewModel.getProducts(smartCollections.id!!)
        proudectFragment = ProductFragment()
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, proudectFragment)?.commit()



    }


}