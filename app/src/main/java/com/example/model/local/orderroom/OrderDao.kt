package com.example.model.local.orderroom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface OrderDao {
    @Insert
    fun addOrder(orderData: OrderData)

    @Query("SELECT * FROM OrderData Where state= :state")
    fun getCanceledOrder(state:String): LiveData<List<OrderData>>


    @Update
     fun updateState(orderData: OrderData)

    @Query("SELECT * FROM OrderData")
    fun getAllOrders(): LiveData<List<OrderData>>

    @Query("SELECT * FROM OrderData Where State= :state")
    fun getOrdersFromState(state: String): LiveData<List<OrderData>>

    @Delete
      fun deleteOrder(orderData: OrderData)

    @Query("DELETE FROM OrderData")
     fun deleteAllOrders()
}