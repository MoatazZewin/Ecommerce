package com.example.ui.fragment.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import com.example.ui.activity.MainActivity
import com.example.ecommerce.databinding.FragmentProductDetailBinding
import com.example.model.local.cartroom.CartProductData
import com.example.model.local.favoriteRoom.FavoriteProduct
import com.example.ui.adapter.PagerAdapter
import com.example.ui.viewmodel.BrandViewModel


class ProductDetail : AppCompatActivity() {

    private lateinit var binding: FragmentProductDetailBinding
    private lateinit var brandViewModel: BrandViewModel
    private lateinit var pagerAdapter: PagerAdapter
    private lateinit var addToCard: AddtoCard
    private lateinit var favorite: FavoriteProduct
    private lateinit var cart: CartProductData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        brandViewModel = ViewModelProvider(this)[BrandViewModel::class.java]
        pagerAdapter = PagerAdapter(this)
        brandViewModel.getProductsDetail(intent.extras!!.getLong("product_id"))
        brandViewModel.liveDataproductDetail.observe(this, {

            pagerAdapter.setContentList(it.product!!.images)
            binding.viewPagerMain.adapter = pagerAdapter
            binding.qty.text = it.product!!.bodyHtml
            binding.productTitle.text = it.product!!.title
            binding.vendorEditable.text = it.product!!.vendor
            binding.stateEditable.text = it.product?.status
            binding.progressPar.visibility = View.GONE
            binding.prise.text = it.product!!.variants[0].price
//            binding.viewPagerMain.adapter=pagerAdapter
            var product = it.product
//            binding.addToCart.setOnClickListener {
//                product?.let { it1 -> (this as MainActivity).addtoCard(it1) }
//            }



            favorite = FavoriteProduct(
                product?.id!!,
                product.image?.src!!,
                product?.title!!,
                product.variants?.get(0).price!!,
                product.variants.get(0).inventoryQuantity!!,
                1

            )
            cart = CartProductData(
                product?.id!!,
                product.image?.src!!,
                product?.title!!,
                product.variants?.get(0).price!!,
                product.variants.get(0).inventoryQuantity!!,
                1
            )

        })
        binding.addToWishList.setOnClickListener {
            brandViewModel.insert(favorite)
            Toast.makeText(this, "add is sucess", Toast.LENGTH_LONG)
                .show()
        }

//        binding.addToCart.setOnClickListener {
//            Toast.makeText(this, "add is sucess", Toast.LENGTH_LONG)
//                .show()
//            brandViewModel.insertTocart(cart)
//        }
        binding.addToCart.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "add is done", Toast.LENGTH_LONG)
                .show()
            brandViewModel.insertTocart(cart)
        })



    }


//    private fun bindCart() {
//        val cartitem = CartProductData(
//            product.id,
//            sharedPref.getUserInfo().customer?.customerId,
//            product.image.src,
//            product.title,
//            product.variants.get(0).price,
//            product.variants.get(0).inventory_quantity,
//            1
//        )
//        if (product.variants.get(0).inventory_quantity > 0) {
//            viewModel.saveCartList(cartitem)
//        } else {
//            Toast.makeText(
//                requireContext(),
//                "this product not available in  stor now",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }
//
//
//    }
}