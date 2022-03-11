package com.example.model.local.cartroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ProductCart")

data class CartProductData(
    @PrimaryKey(autoGenerate = true)
@ColumnInfo(name="id")
    val id: Long,
    @ColumnInfo(name="image")
    val image: String,
    @ColumnInfo(name="title")
    val title: String,
    @ColumnInfo(name="price")
    val price: String,
    @ColumnInfo(name="variants")
    var inventory_quantity: Int,
    @ColumnInfo(name = "count")
    var count: Int


)
