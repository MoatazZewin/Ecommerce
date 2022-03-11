package com.example.model.local.orderroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderData(
    @PrimaryKey
  
    @ColumnInfo(name="orderNumber")
    val orderNumber:Long,


    @ColumnInfo(name = "totalPrice")
    val totalPrice: String,

    @ColumnInfo(name = "CustomerName")
    val customerName: String,

    @ColumnInfo(name = "Address")
    val address: String,

    @ColumnInfo(name = "Phone")
    val phone: String,

    @ColumnInfo(name = "PayMethod")
    val payMethod: String,

    @ColumnInfo(name = "state")
    val state: String
        )



