package com.example.ui.repository

import com.example.model.retrofit.InterfacApi

class BrandRepository(private val api:InterfacApi) {

    suspend fun getBrands()=api.getBrands()
    suspend fun getAllProduct(brandId:Long)=api.getCollectionProducts(brandId)



}