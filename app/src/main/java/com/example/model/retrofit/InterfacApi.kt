package com.example.model.retrofit

import com.example.model.dataClass.category.CategoryResponse
import com.example.model.dataClass.brand.Brands
import com.example.model.dataClass.customcollection.ResCustomCollection
import com.example.model.dataClass.customer.CustomerModel
import com.example.model.dataClass.customer.CustomersModel
import com.example.model.dataClass.product.ResProducts
import com.example.model.dataClass.productdetail.ProductDetails
import retrofit2.Response
import retrofit2.http.*


interface InterfacApi {

    @GET("custom_collections.json")
    suspend fun getAllCollections(): Response<ResCustomCollection>

    @GET("products.json")
    suspend fun getAllProduct(): Response<ResProducts>



    @GET("collections/{collection_id}/products.json")
    suspend fun getCollectionProducts(  @Path("collection_id") collection_id:Long):Response<ResProducts>

    @GET("products/{product_id}.json")
    suspend fun getProductDetails(@Path("product_id") product_id:Long): Response<ProductDetails>


    @GET("smart_collections.json")
    suspend fun getBrands(): Response<Brands>



    @GET("collections/398033617127/products.json")
    suspend  fun getOnHomeProductsList(): Response<ResProducts>

    @GET("collections/398034600167/products.json")
    suspend fun getWomenProductsList(): Response<CategoryResponse>
    @GET("collections/398034632935/products.json")
    suspend fun getKidsProductsList(): Response<CategoryResponse>
    //
    @GET("collections/398034567399/products.json")
    suspend fun getMenProductsList(): Response<CategoryResponse>

    @GET("collections/398034665703/products.json")
    suspend fun getOnSaleProductsList(): Response<CategoryResponse>

    //retrieve Single product
//    @GET("products/{product_id}.json")
//    suspend fun getSingleProduct( @Path("product_id") product_id:Long):Response<ProductCollectionResponse>

    //Auth
    @POST("customers.json")
    suspend fun register(@Body customer: CustomerModel):
            Response<CustomerModel>

    @GET("customers.json")
    suspend fun login(): Response<CustomersModel>


}

