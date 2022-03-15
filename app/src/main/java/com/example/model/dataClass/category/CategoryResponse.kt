package com.example.model.dataClass.category

import com.example.example.Products
import com.google.gson.annotations.SerializedName


data class CategoryResponse (

  @SerializedName("products" ) var products : ArrayList<Products> = arrayListOf(),
  @SerializedName("product_type") var productType : ArrayList<Products> = arrayListOf()

)