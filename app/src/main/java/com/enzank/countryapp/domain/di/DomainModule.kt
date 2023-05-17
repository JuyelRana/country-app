package com.enzank.countryapp.domain.di

import com.enzank.countryapp.domain.repository.CountryRepository
import com.enzank.countryapp.domain.use_cases.GetCountryDetailsUseCase
import com.enzank.countryapp.domain.use_cases.GetCountryListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun providesGetCountryListUseCase(countryRepository: CountryRepository): GetCountryListUseCase {
        return GetCountryListUseCase(countryRepository = countryRepository)
    }

    @Provides
    fun providesGetCountryDetailsUseCase(countryRepository: CountryRepository): GetCountryDetailsUseCase {
        return GetCountryDetailsUseCase(countryRepository = countryRepository)
    }
}