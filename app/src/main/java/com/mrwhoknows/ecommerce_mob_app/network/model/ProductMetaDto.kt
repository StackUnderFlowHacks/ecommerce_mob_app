package com.mrwhoknows.ecommerce_mob_app.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductMetaDto(
    @Json(name = "isInStock")
    val isInStock: Boolean? = null,
    @Json(name = "manufacturer")
    val manufacturer: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "paymentOption")
    val paymentOption: String? = null,
    @Json(name = "price")
    val price: Int? = null,
    @Json(name = "productId")
    val productId: Int? = null,
    @Json(name = "productSlug")
    val productSlug: String? = null,
    @Json(name = "stock")
    val stock: Int? = null,
    @Json(name = "thumbnail")
    val thumbnail: String? = null
)