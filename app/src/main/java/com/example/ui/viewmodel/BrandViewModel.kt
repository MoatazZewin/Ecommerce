package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.model.dataClass.brand.Brands
import com.example.model.dataClass.product.ResProducts
import com.example.model.retrofit.RetrofitInstance
import com.example.ui.repository.BrandRepository
import kotlinx.coroutines.launch

class BrandViewModel(application:Application):AndroidViewModel(application){

    private val brandRepositry = BrandRepository(RetrofitInstance.api)

    private val mutableResponse = MutableLiveData<Brands>()
    val liveDataResponse: LiveData<Brands> get() = mutableResponse

    private val mutableProductsResponse = MutableLiveData<ResProducts>()
    val liveDataAllProducts: LiveData<ResProducts> get() = mutableProductsResponse
    init{
        getBrands()
    }

    private fun getBrands() {
        viewModelScope.launch {
            val response = brandRepositry.getBrands()
            if(response.isSuccessful)
            {
                mutableResponse.postValue(response.body())
            }
        }

    }

     fun getProducts(brandId:Long) {
        viewModelScope.launch {
            val response = brandRepositry.getAllProduct(brandId)
            if(response.isSuccessful)
            {
                mutableProductsResponse.postValue(response.body())
            }
        }

    }


}