package com.mrwhoknows.ecommerce_mob_app.repository

import com.mrwhoknows.ecommerce_mob_app.domain.model.Product
import com.mrwhoknows.ecommerce_mob_app.domain.model.ProductMeta

interface ProductRepository {

    suspend fun getProductById(id: String): Product

    suspend fun getProductMetaList(): List<ProductMeta>
}