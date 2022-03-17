package com.example.ecommerce

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.example.ecommerce.databinding.FragmentSearchBinding
import com.example.model.dataClass.product.Product
import com.example.model.retrofit.RetrofitInstance.api
import com.example.ui.adapter.ProductsAdapter
import com.example.ui.fragment.category.CategoryAdapter
import com.example.ui.fragment.home.ProductDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SearchFragment : Fragment() ,ProductsAdapter.OnProductClickListner{


    val binding by lazy{
        FragmentSearchBinding.inflate(layoutInflater)
    }
    private lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productsAdapter= ProductsAdapter(requireActivity(),this)

        binding.rvSearch.apply {
            adapter = productsAdapter
        }

        binding.etSearch.doOnTextChanged{s,_,_,_->
            lifecycleScope.launch {
                val res = api.getAllProduct()

                if(res.isSuccessful){
                    val list = res.body()?.products?.filter {
                        it.title.contains(s?:"")
                    }

                    withContext(Dispatchers.Main){
                        productsAdapter.addList(list?: emptyList())
                    }

                }else{
                    withContext(Dispatchers.Main){
                        productsAdapter.addList(emptyList())
                    }
                }
            }
        }


    }

     override fun onProductClick(mylist: Product, position: Int) {
//        brandViewModel.getProductsDetail(mylist.id)
//        productDetail = ProductDetail()
        var intent = Intent(requireContext(), ProductDetail::class.java)
        intent.putExtra("product_id", mylist.id)
        startActivity(intent)

    }

}