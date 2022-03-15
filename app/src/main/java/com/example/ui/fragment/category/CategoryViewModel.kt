package com.example.ui.fragment.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.dataClass.category.CategoryResponse
import com.example.model.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class CategoryViewModel:ViewModel() {
    private val categoryRepository = CategoryRepo(RetrofitInstance.api)
    private val productResponse = MutableLiveData<CategoryResponse>()
    val liveDataResponse: LiveData<CategoryResponse> get() = productResponse
    private val menResponse = MutableLiveData<CategoryResponse>()
    val liveDataResponse2: LiveData<CategoryResponse> get() = menResponse
    private val kidsResponse = MutableLiveData<CategoryResponse>()
    val liveDataResponse3: LiveData<CategoryResponse> get() = kidsResponse
    private val salesResponse = MutableLiveData<CategoryResponse>()
    val liveDataResponse4: LiveData<CategoryResponse> get() = salesResponse
    private val errorMutable = MutableLiveData<String>()

    init {
        getWomanProductsList()
        getMenProductsList()
        getKidsProductsList()
        getOnSaleProductsList()

    }
    private fun getWomanProductsList() {
        viewModelScope.launch(Dispatchers.IO) {
            val repo = categoryRepository.getWomanProducts()
            if (repo.isSuccessful){
                productResponse.postValue(repo.body())
            }
            cancel()
        }
    }
    private fun getKidsProductsList() {
        viewModelScope.launch(Dispatchers.IO) {
            val repo = categoryRepository.getKidsProducts()
            if (repo.isSuccessful){
                kidsResponse.postValue(repo.body())
            }else {
                handleError("No data to show")
            }
            cancel()
        }
    }
    private fun getMenProductsList() {
        viewModelScope.launch(Dispatchers.IO) {
            val repo = categoryRepository.getMenProducts()
            if (repo.isSuccessful){
                menResponse.postValue(repo.body())
            } else {
                handleError("No data to show")
            }
            cancel()
        }
    }
    private fun getOnSaleProductsList() {
        viewModelScope.launch(Dispatchers.IO) {
            val repo = categoryRepository.getOnSaleProducts()
            if (repo.isSuccessful){
                salesResponse.postValue(repo.body())
            } else {
                handleError("No data to show")
            }
            cancel()
        }
    }
    private fun handleError(errorMsg: String) {
        errorMutable.postValue(errorMsg)
    }
}