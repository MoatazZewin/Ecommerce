package com.example.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.ecommerce.HomeFragment
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentProductBinding
import com.example.model.dataClass.product.Product
import com.example.ui.adapter.ProductsAdapter
import com.example.ui.fragment.home.ProductDetail
import com.example.ui.viewmodel.BrandViewModel


class ProductFragment : Fragment(),ProductsAdapter.OnProductClickListner {

    private var _binding:FragmentProductBinding? = null
    private lateinit var brandViewModel: BrandViewModel
    private lateinit var productsAdapter: ProductsAdapter
    lateinit var homeFragment: HomeFragment
    lateinit var productDetail:ProductDetail

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentProductBinding.inflate(inflater, container,false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        brandViewModel=ViewModelProvider(requireActivity())[BrandViewModel::class.java]
        brandViewModel.liveDataAllProducts.observe(viewLifecycleOwner,{
            productsAdapter= ProductsAdapter(requireActivity(),this)
            productsAdapter.addList(it.products)

            binding.productRecycler.adapter=productsAdapter
            binding.leftIconLogin.setOnClickListener {
                homeFragment = HomeFragment()
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, homeFragment)?.commit()
            }
//            binding.toolbar.setNavigationOnClickListener{
//
//            }
        })


    }

    override fun onPause() {
        super.onPause()
        productsAdapter.addList(emptyList())
        homeFragment = HomeFragment()
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, homeFragment)?.commit()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    override fun onProductClick(mylist: Product, position: Int) {
//        brandViewModel.getProductsDetail(mylist.id)
//        productDetail = ProductDetail()
        var intent = Intent(requireContext(),ProductDetail::class.java)
        intent.putExtra("product_id", mylist.id)
        startActivity(intent)

    }


}