package com.mrwhoknows.ecommerce_mob_app.di

import com.mrwhoknows.ecommerce_mob_app.network.service.ProductService
import com.mrwhoknows.ecommerce_mob_app.network.service.UserService
import com.mrwhoknows.ecommerce_mob_app.network.util.ProductDtoMapper
import com.mrwhoknows.ecommerce_mob_app.network.util.ProductMetaDtoMapper
import com.mrwhoknows.ecommerce_mob_app.network.util.UserDtoMapper
import com.mrwhoknows.ecommerce_mob_app.repository.ProductRepository
import com.mrwhoknows.ecommerce_mob_app.repository.ProductRepositoryImpl
import com.mrwhoknows.ecommerce_mob_app.repository.UserRepository
import com.mrwhoknows.ecommerce_mob_app.repository.UserRepositoryImpl
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

    @Singleton
    @Provides
    fun provideUserRepository(
        userService: UserService,
        userDtoMapper: UserDtoMapper
    ): UserRepository =
        UserRepositoryImpl(userService, userDtoMapper)

}