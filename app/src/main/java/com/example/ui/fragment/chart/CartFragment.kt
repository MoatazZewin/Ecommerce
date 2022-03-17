package com.example.ui.fragment.chart

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerce.HomeFragment
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentAllWishListBinding
import com.example.ecommerce.databinding.FragmentCBinding
import com.example.ecommerce.databinding.FragmentChartBinding
import com.example.ui.fragment.favorite.FavoriteAdapter
import com.example.ui.fragment.favorite.FavoriteViewModel
import com.example.ui.fragment.profile.AuthRepo
import com.example.ui.fragment.profile.SignInFragment


class CartFragment : Fragment() {
    private lateinit var application: Application
    private lateinit var  authRepo: AuthRepo
    private lateinit var binding: FragmentChartBinding
    //    private lateinit var viewModel: FavoriteViewModel
    private lateinit var homeFragment: HomeFragment
    private lateinit var cartAdapter: CartAdapter
    private lateinit var singinFragment:SignInFragment
    val viewModel by lazy {
        CartViewModel.create(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chart, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.leftIconInLogin.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, homeFragment)?.commit()
        }
        singinFragment = SignInFragment()
        binding.buttonSingin.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, singinFragment)?.commit()
        }
        if (viewModel.repo.sharedPref.getSettings().customer == null)
        {
            binding.Login.visibility = View.GONE
            binding.notLogin.visibility = View.VISIBLE
        }else
        {
            binding.Login.visibility = View.VISIBLE
            binding.notLogin.visibility = View.GONE
            binding.emptyAnimationView.visibility = View.GONE
            binding.emptyText.visibility = View.GONE
            binding.buttonSingin.visibility =View.GONE
            viewModel.getAllCartList().observe(viewLifecycleOwner, Observer { product ->
                cartAdapter= CartAdapter(product,requireContext(),viewModel)
                binding.wishRecyclerView.apply {
                    adapter=cartAdapter
                    layoutManager=
                        GridLayoutManager(requireContext(),3, LinearLayoutManager.VERTICAL,false)
                }

            })
        }


    }


}