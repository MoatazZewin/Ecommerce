package com.example.ui.fragment.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentKidBinding


class KidFragment : Fragment() {
    private lateinit var _binding: FragmentKidBinding
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var recyclerViewAdapterProduct: CategoryAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_kid, container, false)
        _binding = FragmentKidBinding.inflate(inflater, container, false)
        return _binding.root

    }
    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewAdapterProduct= CategoryAdapter(requireContext())
        categoryViewModel = ViewModelProvider(requireActivity())[CategoryViewModel::class.java]

        categoryViewModel.liveDataResponse3.observe(viewLifecycleOwner,{
            val productList=it.products
            recyclerViewAdapterProduct.addList(productList)
            _binding.recyclerViewMyProduct2.adapter=recyclerViewAdapterProduct
        })

    }

}