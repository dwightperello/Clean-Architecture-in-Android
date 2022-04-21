package com.meat.samplecleanarchitecture.di

import com.meat.samplecleanarchitecture.common.Constants
import com.meat.samplecleanarchitecture.data.remote.api.API_service
import com.meat.samplecleanarchitecture.data.repository.CoinRepositoryImpl
import com.meat.samplecleanarchitecture.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesAPI():API_service{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API_service::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository (api:API_service):CoinRepository{
        return CoinRepositoryImpl(api)
    }
}