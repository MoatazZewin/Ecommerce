package com.example.ui.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.example.model.local.RoomService
import com.example.model.local.cartroom.CartProductData
import com.example.model.local.favoriteRoom.FavoriteDao
import com.example.model.local.favoriteRoom.FavoriteProduct
import com.example.model.retrofit.InterfacApi

class Repository(private val api:InterfacApi, private val application:Application) {

    val database = RoomService.getInstance(application)?.wishDao()
    val databasecart = RoomService.getInstance(application)?.caerDao()

    suspend fun getBrands()=api.getBrands()
    suspend fun getAllProduct(brandId:Long)=api.getCollectionProducts(brandId)
    suspend fun getProductsDetail(productId:Long)=api.getProductDetails(productId)

    fun insert(favoriteProduct: FavoriteProduct)= database?.insert(favoriteProduct)
    fun getAllFav():LiveData<List<FavoriteProduct>> = database?.getAllFav()!!
    fun delete(favoriteProduct: FavoriteProduct) =database?.delete(favoriteProduct)
    fun getOneItem(id:Long)= database?.getOneItem(id)

    fun saveAllCartList(cartProduct: CartProductData) = databasecart?.saveAllCartList(cartProduct)
    fun getAllCartList(): LiveData<List<CartProductData>> = databasecart?.getAllCartList()!!
    fun deleteOnCartItem(cartProduct: CartProductData)  = databasecart?.deleteOnCartItem(cartProduct)
    fun getCountUpdate(cartProduct: CartProductData) = databasecart?.getCountUpdate(cartProduct)







}