package com.mrwhoknows.ecommerce_mob_app.domain.model

data class ProductMeta(
    val isInStock: Boolean? = null,
    val manufacturer: String? = null,
    val name: String? = null,
    val paymentOption: String? = null,
    val price: Int? = null,
    val productId: Int? = null,
    val productSlug: String? = null,
    val stock: Int? = null,
    val thumbnail: String? = null
)