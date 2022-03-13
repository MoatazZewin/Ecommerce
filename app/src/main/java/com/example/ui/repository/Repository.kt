package com.example.ui.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.model.local.RoomService
import com.example.model.local.favoriteRoom.FavoriteDao
import com.example.model.local.favoriteRoom.FavoriteProduct
import com.example.model.retrofit.InterfacApi

class Repository(private val api:InterfacApi, private val application:Application) {

    val database = RoomService.getInstance(application)?.wishDao()

    suspend fun getBrands()=api.getBrands()
    suspend fun getAllProduct(brandId:Long)=api.getCollectionProducts(brandId)
    suspend fun getProductsDetail(productId:Long)=api.getProductDetails(productId)

    fun insert(favoriteProduct: FavoriteProduct)= database?.insert(favoriteProduct)
    fun getAllFav():LiveData<List<FavoriteProduct>> = database?.getAllFav()!!
    fun delete(favoriteProduct: FavoriteProduct) =database?.delete(favoriteProduct)
    fun getOneItem(id:Long)= database?.getOneItem(id)





}