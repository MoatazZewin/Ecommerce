package com.example.ui.fragment.category

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentKidFilterBinding
import com.example.ecommerce.databinding.FragmentManFilterBinding
import com.example.example.Products
import com.example.ui.fragment.home.ProductDetail


class KidFilterFragment : Fragment(),CategoryAdapter.OnItemClickListener {

   private lateinit var _binding: FragmentKidFilterBinding
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var categoryAdapter: CategoryAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_kid_filter, container, false)
        _binding = FragmentKidFilterBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment

        categoryViewModel = ViewModelProvider(requireActivity())[CategoryViewModel::class.java]
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var flag =this.arguments?.get("Flag")
        var collectionName :String = when(flag){
            "0" ->  "ACCESSORIES"
            "1" ->  "T-SHIRTS"
            "2" ->  "SHOES"
            else ->  "ACCESSORIES"
        }
        categoryAdapter = CategoryAdapter(requireContext(),this)
        categoryViewModel = ViewModelProvider(requireActivity())[CategoryViewModel::class.java]
        categoryViewModel.liveDataResponse3.observe(viewLifecycleOwner,{
            var productList = it.products
            var list :MutableList<Products> = mutableListOf()
            for (i in productList)
            {
                if ((i.productType.equals(collectionName))){
                    list.add(i)

                }
            }
            categoryAdapter.addList(list)
            _binding.recyclerkidd.adapter= categoryAdapter

        })

    }


    override fun onItemClickProduct(product: Products, position: Int) {
        val intent = Intent(requireContext(), ProductDetail::class.java)
        intent.putExtra("product_id",product.id)
//        intent.putExtra("cart_b",product)
        startActivity(intent)

    }

}