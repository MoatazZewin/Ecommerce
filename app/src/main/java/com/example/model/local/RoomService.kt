package com.example.model.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.model.local.cartroom.CartProductData
import com.example.model.local.cartroom.LocalDataDao
import com.example.model.local.favoriteRoom.FavoriteDao
import com.example.model.local.favoriteRoom.FavoriteProduct
import com.example.model.local.orderroom.OrderDao
import com.example.model.local.orderroom.OrderData


@Database(entities = [CartProductData::class,FavoriteProduct::class,OrderData::class]
    , version = 1,exportSchema = false)

abstract class RoomService : RoomDatabase() {
    abstract fun wishDao(): FavoriteDao
    abstract fun caerDao(): LocalDataDao
    abstract fun orderDao(): OrderDao

    companion object{
        @Volatile
        private var db : RoomService? =null

        fun getInstance(application: Application): RoomService? {
            synchronized(this) {
                if (db == null)
                    db = Room.databaseBuilder(
                        application, RoomService::class.java, "database"
                    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return db
        }

    }




}