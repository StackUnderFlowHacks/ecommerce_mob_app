package com.mrwhoknows.ecommerce_mob_app.network.response


import com.mrwhoknows.ecommerce_mob_app.network.model.ProductMetaDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductMetaListResponse(
    @Json(name = "response")
    val response: Response? = null,
    @Json(name = "status")
    val status: Boolean? = null
) {
    @JsonClass(generateAdapter = true)
    data class Response(
        @Json(name = "categories")
        val categories: List<String?>? = null,
        @Json(name = "products")
        val products: List<ProductMetaDto>? = null,
        @Json(name = "total_products")
        val totalProducts: Int? = null
    )
}