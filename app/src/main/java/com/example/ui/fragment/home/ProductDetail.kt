package com.example.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerce.MainActivity
import com.example.ecommerce.databinding.FragmentProductDetailBinding
import com.example.model.local.favoriteRoom.FavoriteProduct
import com.example.ui.adapter.PagerAdapter
import com.example.ui.fragment.favorite.FavoriteAdapter
import com.example.ui.viewmodel.BrandViewModel


class ProductDetail : Fragment() {

    private lateinit var binding:FragmentProductDetailBinding
    private lateinit var brandViewModel: BrandViewModel
    private lateinit var pagerAdapter: PagerAdapter
    private lateinit var addToCard:AddtoCard
    private lateinit var favorite:FavoriteProduct


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
            var product=it.product
            binding.addToCart.setOnClickListener {
                product?.let { it1 -> (requireActivity() as MainActivity).addtoCard(it1) }
            }

            favorite= FavoriteProduct(
                product?.id!!,
                product.image?.src!!,
                product?.title!!,
                product.variants?.get(0).price!!,
                product.variants.get(0).inventoryQuantity!!,
                1

            )

        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addToWishList.setOnClickListener {
            brandViewModel.insert(favorite)
        }

    }


}