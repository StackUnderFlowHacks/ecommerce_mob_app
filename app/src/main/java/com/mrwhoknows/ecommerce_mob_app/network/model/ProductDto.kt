package com.mrwhoknows.ecommerce_mob_app.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductDto(
    @Json(name = "brand")
    val brand: String? = null,
    @Json(name = "categories")
    val categories: List<String?>? = null,
    @Json(name = "countryOfOrigin")
    val countryOfOrigin: String? = null,
    @Json(name = "coupons")
    val coupons: List<String?>? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "discount")
    val discount: String? = null,
    @Json(name = "isInStock")
    val isInStock: Boolean? = null,
    @Json(name = "manufacturer")
    val manufacturer: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "paymentOption")
    val paymentOption: String? = null,
    @Json(name = "photos")
    val photos: List<String?>? = null,
    @Json(name = "price")
    val price: Int? = null,
    @Json(name = "productId")
    val productId: Int? = null,
    @Json(name = "productSlug")
    val productSlug: String? = null,
    @Json(name = "rating")
    val rating: String? = null,
    @Json(name = "stock")
    val stock: Int? = null,
    @Json(name = "thumbnail")
    val thumbnail: String? = null
)