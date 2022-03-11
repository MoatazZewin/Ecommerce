package com.example.model.local.favoriteRoom

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(favoriteProduct: FavoriteProduct)

    @Delete
     fun delete(favoriteProduct: FavoriteProduct)

    @Query("DELETE FROM FavoriteProduct")
     fun deleteAll()

    @Query("DELETE FROM FavoriteProduct Where id= :id")
     fun deleteById(id:Long)

    @Query ("SELECT * FROM FavoriteProduct")
    fun getAllFav():LiveData<List<FavoriteProduct>>

    @Query ("SELECT * FROM FavoriteProduct Where id= :id")
    fun getOneItem(id:Long):LiveData<FavoriteProduct>
}