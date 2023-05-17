package com.enzank.countryapp.data.di

import com.enzank.countryapp.data.network.ApiService
import com.enzank.countryapp.data.repository.CountryRepositoryImpl
import com.enzank.countryapp.domain.repository.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl("https://restcountries.com/v3.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java);
    }

    @Provides
    fun provideCountryRepository(apiService: ApiService): CountryRepository {
        return CountryRepositoryImpl(apiService)
    }
}