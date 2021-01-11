package com.mrwhoknows.ecommerce_mob_app.domain.model

data class Product(
    val brand: String? = null,
    val categories: List<String?>,
    val countryOfOrigin: String,
    val coupons: List<String?>,
    val description: String,
    val discount: String,
    val isInStock: Boolean,
    val manufacturer: String,
    val name: String,
    val paymentOption: String,
    val photos: List<String?>,
    val price: Int,
    val productId: Int,
    val productSlug: String,
    val rating: String,
    val stock: Int,
    val thumbnail: String
)