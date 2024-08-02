package com.fermers_marketplace.unsplash2_0.di

import android.content.Context
import com.fermers_marketplace.unsplash2_0.common.NetworkChecker
import com.fermers_marketplace.unsplash2_0.constants.Const.BASE_URL
import com.fermers_marketplace.unsplash2_0.services.apiservices.UnsplashApi
import com.fermers_marketplace.unsplash2_0.services.apiservices.UnsplashApiService
import com.fermers_marketplace.unsplash2_0.services.photoDownloadService.AndroidPhotoDownloader
import com.fermers_marketplace.unsplash2_0.services.photoDownloadService.PhotoDownloader
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    fun provideApi(retrofit: Retrofit): UnsplashApi =
        retrofit.create(UnsplashApi::class.java)

    @Provides
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()

    @Provides
    fun providePhotoApiService(unsplashApi: UnsplashApi): UnsplashApiService =
        UnsplashApiService(unsplashApi)

    @Provides
    fun providePhotoDownloader(context: Context): PhotoDownloader =
        AndroidPhotoDownloader(context)

    @Provides
    fun provideNetworkConnected(context: Context): NetworkChecker =
        NetworkChecker(context)
}