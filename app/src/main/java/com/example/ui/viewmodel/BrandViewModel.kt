package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.model.dataClass.brand.Brands
import com.example.model.dataClass.product.ResProducts
import com.example.model.dataClass.productdetail.ProductDetails
import com.example.model.local.cartroom.CartProductData
import com.example.model.local.favoriteRoom.FavoriteProduct
import com.example.model.retrofit.RetrofitInstance
import com.example.ui.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BrandViewModel(application:Application):AndroidViewModel(application){

    private val repositry = Repository(RetrofitInstance.api,application)


    fun insert(favoriteProduct: FavoriteProduct)=viewModelScope.launch {
        repositry.insert(favoriteProduct)
    }
    fun insertTocart(cartProductData: CartProductData)=viewModelScope.launch {
        repositry.saveAllCartList(cartProductData)
    }

    private val brandRepositry = Repository(RetrofitInstance.api,application)

    private val mutableResponse = MutableLiveData<Brands>()
    val liveDataResponse: LiveData<Brands> get() = mutableResponse



    private val mutableProductsResponse = MutableLiveData<ResProducts>()
    val liveDataAllProducts: LiveData<ResProducts> get() = mutableProductsResponse

    private val produstDetail=MutableLiveData<ProductDetails>()
    val liveDataproductDetail:LiveData<ProductDetails>get() = produstDetail



    init{
        getBrands()
    }

    private fun getBrands() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = brandRepositry.getBrands()
            if(response.isSuccessful)
            {
                mutableResponse.postValue(response.body())
            }
        }

    }

     fun getProducts(brandId:Long) {
        viewModelScope.launch (Dispatchers.IO){
            val response = brandRepositry.getAllProduct(brandId)
            if(response.isSuccessful)
            {
                mutableProductsResponse.postValue(response.body())
            }
        }

    }


    fun getProductsDetail(ProductId:Long) {
        viewModelScope.launch (Dispatchers.IO){
            val response = brandRepositry.getProductsDetail(ProductId!!)
            if(response.isSuccessful)
            {
                produstDetail.postValue(response.body())
            }
        }

    }




}