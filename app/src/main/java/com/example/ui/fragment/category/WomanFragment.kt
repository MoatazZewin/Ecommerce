package com.example.ui.fragment.category

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentWomanBinding
import com.example.example.Products
import com.example.ui.fragment.home.ProductDetail


class WomanFragment : Fragment(),CategoryAdapter.OnItemClickListener {
    private lateinit var _binding: FragmentWomanBinding
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var recyclerViewAdapterProduct: CategoryAdapter
    var clicked = false
    private lateinit var womanFilterFragment:WomanFilterFragment



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_woman, container, false)
        _binding = FragmentWomanBinding.inflate(inflater, container, false)
        return _binding.root

    }
    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewAdapterProduct= CategoryAdapter(requireContext(),this)
        categoryViewModel = ViewModelProvider(requireActivity())[CategoryViewModel::class.java]

        categoryViewModel.liveDataResponse.observe(viewLifecycleOwner,{
            val productList=it.products
            recyclerViewAdapterProduct.addList(productList)
            _binding.recyclerViewMyProduct2.adapter=recyclerViewAdapterProduct

        })
        _binding.mainFloating.setOnClickListener{
            clicked()

        }
        _binding.tshirtFloating.setOnClickListener{
            var bundle  = Bundle()
            bundle.putString("Flag","0")
            womanFilterFragment = WomanFilterFragment()
            womanFilterFragment.arguments = bundle
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container,womanFilterFragment )?.commit()
        }
        _binding.shoseFloating.setOnClickListener{

            var bundle  = Bundle()
            bundle.putString("Flag","1")
            womanFilterFragment = WomanFilterFragment()
            womanFilterFragment.arguments = bundle
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container,womanFilterFragment )?.commit()
        }
        _binding.accessFloating.setOnClickListener{
            var bundle  = Bundle()
            bundle.putString("Flag","2")
            womanFilterFragment = WomanFilterFragment()
            womanFilterFragment.arguments = bundle
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container,womanFilterFragment )?.commit()
        }



    }
    fun clicked()
    {
        setvisiblity(clicked)
        clicked =! clicked

    }
    fun setvisiblity(clicked:Boolean)
    {
        if (!clicked)
        {
            _binding.accessFloating.visibility = View.VISIBLE
            _binding.shoseFloating.visibility = View.VISIBLE
            _binding.tshirtFloating.visibility = View.VISIBLE

        }else
        {
            _binding.accessFloating.visibility = View.INVISIBLE
            _binding.shoseFloating.visibility =  View.INVISIBLE
            _binding.tshirtFloating.visibility =  View.INVISIBLE
        }
    }

    override fun onItemClickProduct(product: Products, position: Int) {

        val intent = Intent(requireContext(), ProductDetail::class.java)
        intent.putExtra("product_id",product.id)
//        intent.putExtra("cart_b",product)
        startActivity(intent)

    }

}