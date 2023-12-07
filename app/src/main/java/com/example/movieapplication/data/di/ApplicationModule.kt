package com.example.movieapplication.data.di

import com.example.movieapplication.data.api.ApplicationService
import com.example.movieapplication.utils.Constants
import com.example.movieapplication.utils.Utils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideApplicationService(): ApplicationService = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(Utils.client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApplicationService::class.java)
}
