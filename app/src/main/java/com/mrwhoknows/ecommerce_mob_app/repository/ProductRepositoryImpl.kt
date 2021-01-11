package com.mrwhoknows.ecommerce_mob_app.repository

import com.mrwhoknows.ecommerce_mob_app.domain.model.Product
import com.mrwhoknows.ecommerce_mob_app.domain.model.ProductMeta
import com.mrwhoknows.ecommerce_mob_app.network.service.ProductService
import com.mrwhoknows.ecommerce_mob_app.network.util.ProductDtoMapper
import com.mrwhoknows.ecommerce_mob_app.network.util.ProductMetaDtoMapper

class ProductRepositoryImpl(
    private val productService: ProductService,
    private val productDtoMapper: ProductDtoMapper,
    private val productMetaDtoMapper: ProductMetaDtoMapper
) : ProductRepository {

    override suspend fun getProductById(id: String): Product {
        val result = productService.getProductById(id).response!!
        return productDtoMapper.mapToDomainModel(result)
    }

    override suspend fun getProductMetaList(): List<ProductMeta> {
        val result = productService.getProducts().response?.products!!
        return productMetaDtoMapper.mapToDomainList(result)
    }
}