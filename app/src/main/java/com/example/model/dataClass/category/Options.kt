package com.example.example

import com.google.gson.annotations.SerializedName


data class Options (

  @SerializedName("id"         ) var id        : Int?    = null,
  @SerializedName("product_id" ) var productId : Int?    = null,
  @SerializedName("name"       ) var name      : String? = null,
  @SerializedName("position"   ) var position  : Int?    = null

)