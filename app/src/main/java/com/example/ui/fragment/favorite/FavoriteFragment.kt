package com.example.ui.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentAllWishListBinding

class FavoriteFragment  : Fragment(){
    private lateinit var binding: FragmentAllWishListBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var favAdapter: FavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all_wish_list, container, false)
        viewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllFav().observe(viewLifecycleOwner, Observer { product ->
            favAdapter= FavoriteAdapter(product,requireContext(),viewModel)
            binding.wishRecyclerView.apply {
                adapter=favAdapter
                layoutManager=GridLayoutManager(requireContext(),3,LinearLayoutManager.VERTICAL,false)
            }

        })

    }
}