package com.example.model.dataClass.product


import com.google.gson.annotations.SerializedName

data class Option(
    val id: Long,
    val name: String,
    val position: Int,
    @SerializedName("product_id")
    val productId: Long,
    val values: List<String>
)