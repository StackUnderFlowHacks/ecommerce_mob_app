package com.mrwhoknows.ecommerce_mob_app.di

import com.mrwhoknows.ecommerce_mob_app.network.service.ProductService
import com.mrwhoknows.ecommerce_mob_app.network.util.ProductDtoMapper
import com.mrwhoknows.ecommerce_mob_app.network.util.ProductMetaDtoMapper
import com.mrwhoknows.ecommerce_mob_app.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Singleton
    @Provides
    fun provideBaseUrl(): String = BASE_URL

    @Singleton
    @Provides
    fun provideProductService(baseUrl: String, client: OkHttpClient): ProductService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(ProductService::class.java)
    }

    @Singleton
    @Provides
    fun provideProductMapper(): ProductDtoMapper = ProductDtoMapper()

    @Singleton
    @Provides
    fun provideProductMetaMapper(): ProductMetaDtoMapper = ProductMetaDtoMapper()
}