package com.example.example

import com.google.gson.annotations.SerializedName


data class CategoryResponse (

  @SerializedName("products" ) var products : ArrayList<Products> = arrayListOf()

)