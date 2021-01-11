package com.mrwhoknows.ecommerce_mob_app.domain.model

data class Product(
    val brand: String? = null,
    val categories: List<String?>? = null,
    val countryOfOrigin: String? = null,
    val coupons: List<String?>? = null,
    val description: String? = null,
    val discount: String? = null,
    val isInStock: Boolean? = null,
    val manufacturer: String? = null,
    val name: String? = null,
    val paymentOption: String? = null,
    val photos: List<String?>? = null,
    val price: Int? = null,
    val productId: Int? = null,
    val productSlug: String? = null,
    val rating: String? = null,
    val stock: Int? = null,
    val thumbnail: String? = null
)