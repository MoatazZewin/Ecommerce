package com.example.model.dataClass.brand

import com.google.gson.annotations.SerializedName

data class Brands(
    @SerializedName("smart_collections" ) var smartCollections : ArrayList<SmartCollections> = arrayListOf()
)