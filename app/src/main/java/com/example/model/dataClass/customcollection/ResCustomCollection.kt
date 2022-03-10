package com.example.model.dataClass.customcollection


import com.google.gson.annotations.SerializedName

data class ResCustomCollection(
    @SerializedName("custom_collections")
    val customCollections: List<CustomCollection>
)