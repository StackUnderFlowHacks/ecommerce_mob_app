package com.mrwhoknows.ecommerce_mob_app.network.service

import com.mrwhoknows.ecommerce_mob_app.network.response.ProductMetaListResponse
import com.mrwhoknows.ecommerce_mob_app.network.response.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    @GET("products/")
    suspend fun getProducts(): ProductMetaListResponse

    @GET("products/pdns/")
    suspend fun getProductById(@Query("id") id: String): ProductResponse

}