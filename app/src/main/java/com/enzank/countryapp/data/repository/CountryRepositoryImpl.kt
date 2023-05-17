package com.enzank.countryapp.data.repository

import com.enzank.countryapp.common.toDomain
import com.enzank.countryapp.data.network.ApiService
import com.enzank.countryapp.domain.model.Country
import com.enzank.countryapp.domain.model.CountryDetails
import com.enzank.countryapp.domain.repository.CountryRepository

class CountryRepositoryImpl(private val apiService: ApiService) : CountryRepository {
    override suspend fun getCountryList(): List<Country> {
        return apiService.getCountryList().map { it.toDomain() }
    }

    override suspend fun getCountryDetails(countryName: String): CountryDetails {
        return apiService.getCountryDetails(countryName = countryName).toDomain()
    }
}