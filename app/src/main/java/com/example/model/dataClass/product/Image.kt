package com.example.model.dataClass.product


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("admin_graphql_api_id")
    val adminGraphqlApiId: String,
    val alt: Any,
    @SerializedName("created_at")
    val createdAt: String,
    val height: Int,
    val id: Long,
    val position: Int,
    @SerializedName("product_id")
    val productId: Long,
    val src: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("variant_ids")
    val variantIds: List<Any>,
    val width: Int
)