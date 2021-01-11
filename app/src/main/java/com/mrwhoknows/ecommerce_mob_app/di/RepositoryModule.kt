package com.mrwhoknows.ecommerce_mob_app.di

import com.mrwhoknows.ecommerce_mob_app.network.service.ProductService
import com.mrwhoknows.ecommerce_mob_app.network.util.ProductDtoMapper
import com.mrwhoknows.ecommerce_mob_app.network.util.ProductMetaDtoMapper
import com.mrwhoknows.ecommerce_mob_app.repository.ProductRepository
import com.mrwhoknows.ecommerce_mob_app.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideProductRepository(
        productService: ProductService,
        productDtoMapper: ProductDtoMapper,
        productMetaDtoMapper: ProductMetaDtoMapper
    ): ProductRepository =
        ProductRepositoryImpl(productService, productDtoMapper, productMetaDtoMapper)

}