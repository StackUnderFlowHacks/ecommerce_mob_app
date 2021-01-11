package com.mrwhoknows.ecommerce_mob_app.di

import android.content.Context
import com.mrwhoknows.ecommerce_mob_app.presentation.MainApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext context: Context): MainApplication =
        context as MainApplication

}