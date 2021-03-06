package com.example.model.dataClass.customcollection


import com.google.gson.annotations.SerializedName

data class Image(
    val alt: Any,
    @SerializedName("created_at")
    val createdAt: String,
    val height: Int,
    val src: String,
    val width: Int
)