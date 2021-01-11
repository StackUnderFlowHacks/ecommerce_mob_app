package com.mrwhoknows.ecommerce_mob_app.network.util

import com.mrwhoknows.ecommerce_mob_app.domain.model.Product
import com.mrwhoknows.ecommerce_mob_app.network.model.ProductDto
import com.mrwhoknows.ecommerce_mob_app.util.DomainMapper

class ProductDtoMapper : DomainMapper<ProductDto, Product> {
    override fun mapToDomainModel(model: ProductDto): Product {
        return Product(
            brand = model.brand ?: "Not Available",
            categories = model.categories ?: emptyList(),
            countryOfOrigin = model.countryOfOrigin ?: "Not Available",
            coupons = model.coupons ?: emptyList(),
            description = model.description ?: "Not Available",
            discount = model.discount ?: "Not Available",
            isInStock = model.isInStock ?: false,
            manufacturer = model.manufacturer ?: "Not Available",
            name = model.manufacturer ?: "Not Available",
            paymentOption = model.paymentOption ?: "Not Available",
            photos = model.photos ?: emptyList(),
            price = model.price ?: -1,
            productId = model.productId ?: -1,
            productSlug = model.productSlug ?: "Not Available",
            rating = model.rating ?: "Not Available",
            stock = model.stock ?: -1,
            thumbnail = model.thumbnail ?: ""
        )
    }

    override fun mapFromDomainModel(domainModel: Product): ProductDto {
        return ProductDto(
            brand = domainModel.brand,
            categories = domainModel.categories,
            countryOfOrigin = domainModel.countryOfOrigin,
            coupons = domainModel.coupons,
            description = domainModel.description,
            discount = domainModel.discount,
            isInStock = domainModel.isInStock,
            manufacturer = domainModel.manufacturer,
            name = domainModel.manufacturer,
            paymentOption = domainModel.paymentOption,
            photos = domainModel.photos,
            price = domainModel.price,
            productId = domainModel.productId,
            productSlug = domainModel.productSlug,
            rating = domainModel.rating,
            stock = domainModel.stock,
            thumbnail = domainModel.thumbnail
        )
    }
}