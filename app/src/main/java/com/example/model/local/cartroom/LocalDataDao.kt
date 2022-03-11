package com.example.model.local.cartroom

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.model.local.cartroom.CartProductData

@Dao
interface LocalDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun saveAllCartList(cartProduct: CartProductData)

    @Query("SELECT * FROM ProductCart")
    fun getAllCartList(): LiveData<List<CartProductData>>
    @Update
     fun getCountUpdate(cartProduct: CartProductData)

    @Delete
      fun deleteOnCartItem(cartProduct: CartProductData)

    @Query("DELETE FROM ProductCart")
     fun deleteAll()







}