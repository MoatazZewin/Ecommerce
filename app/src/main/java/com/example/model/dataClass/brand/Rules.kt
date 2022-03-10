package com.example.model.dataClass.brand

import com.google.gson.annotations.SerializedName

data class Rules (
    @SerializedName("column"    ) var column    : String? = null,
    @SerializedName("relation"  ) var relation  : String? = null,
    @SerializedName("condition" ) var condition : String? = null
)