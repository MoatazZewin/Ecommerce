package com.example.ui.fragment.category

import androidx.room.RoomDatabase
import com.example.model.local.RoomService
import com.example.model.local.orderroom.OrderData
import com.example.model.retrofit.InterfacApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CategoryRepo (private val api:InterfacApi){
    suspend fun getWomanProducts() = api.getWomenProductsList()
    suspend fun getKidsProducts() = api.getKidsProductsList()
    suspend fun getMenProducts() = api.getMenProductsList()
    suspend fun getOnSaleProducts() = api.getOnSaleProductsList()


}
