package com.mrwhoknows.ecommerce_mob_app.network.response


import com.mrwhoknows.ecommerce_mob_app.network.model.ProductDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductResponse(
    @Json(name = "response")
    val response: ProductDto? = null,
    @Json(name = "status")
    val status: Boolean? = null
)