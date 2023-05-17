package com.enzank.countryapp.domain.repository

import com.enzank.countryapp.domain.model.Country
import com.enzank.countryapp.domain.model.CountryDetails

interface CountryRepository {
    suspend fun getCountryList(): List<Country>
    suspend fun getCountryDetails(countryName: String): CountryDetails
}