package com.mrwhoknows.ecommerce_mob_app.network.util

import com.mrwhoknows.ecommerce_mob_app.domain.model.ProductMeta
import com.mrwhoknows.ecommerce_mob_app.network.model.ProductMetaDto
import com.mrwhoknows.ecommerce_mob_app.util.DomainMapper

class ProductMetaDtoMapper : DomainMapper<ProductMetaDto, ProductMeta> {
    override fun mapToDomainModel(model: ProductMetaDto): ProductMeta {
        return ProductMeta(
            isInStock = model.isInStock ?: false,
            manufacturer = model.manufacturer ?: "Not Available",
            name = model.name ?: "Not Available",
            paymentOption = model.paymentOption ?: "Not Available",
            price = model.price ?: 0,
            productId = model.productId ?: -1,
            productSlug = model.productSlug ?: "Not Available",
            stock = model.stock ?: -1,
            thumbnail = model.thumbnail ?: "Not Available",
            rating = model.rating ?: 0.0,
            brand = model.brand ?: "Not Available",
            discount = model.discount ?: 0.0
        )
    }

    override fun mapFromDomainModel(domainModel: ProductMeta): ProductMetaDto {
        return ProductMetaDto(
            isInStock = domainModel.isInStock,
            manufacturer = domainModel.manufacturer,
            name = domainModel.name,
            paymentOption = domainModel.paymentOption,
            price = domainModel.price,
            productId = domainModel.productId,
            productSlug = domainModel.productSlug,
            stock = domainModel.stock,
            thumbnail = domainModel.thumbnail,
            rating = domainModel.rating,
            brand = domainModel.brand,
            discount = domainModel.discount
        )
    }

    fun mapToDomainList(listDto: List<ProductMetaDto>): List<ProductMeta> {
        return listDto.map { productMetaDto ->
            mapToDomainModel(productMetaDto)
        }
    }

    fun mapFromDomainList(listDomain: List<ProductMeta>): List<ProductMetaDto> {
        return listDomain.map { productMeta ->
            mapFromDomainModel(productMeta)
        }
    }
}