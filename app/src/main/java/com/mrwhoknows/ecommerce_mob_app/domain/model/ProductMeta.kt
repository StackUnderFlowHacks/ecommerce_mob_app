package com.mrwhoknows.ecommerce_mob_app.domain.model

data class ProductMeta(
    val isInStock: Boolean,
    val manufacturer: String,
    val name: String,
    val paymentOption: String,
    val price: Int,
    val productId: Int,
    val productSlug: String,
    val stock: Int,
    val thumbnail: String
)