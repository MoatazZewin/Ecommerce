package com.example.ui.fragment.category

import com.example.model.retrofit.InterfacApi

class CategoryRepo (val api:InterfacApi){
    suspend fun getWomanProducts() = api.getWomenProductsList()
    suspend fun getKidsProducts() = api.getKidsProductsList()
    suspend fun getMenProducts() = api.getMenProductsList()
    suspend fun getOnSaleProducts() = api.getOnSaleProductsList()


}
