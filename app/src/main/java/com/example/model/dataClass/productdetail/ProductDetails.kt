package com.example.model.dataClass.productdetail

import com.example.model.dataClass.productdetail.Product
import com.google.gson.annotations.SerializedName


data class ProductDetails (

  @SerializedName("product" ) var product : Product? = Product()

)