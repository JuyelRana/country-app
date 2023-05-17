package com.enzank.countryapp.data.network

import com.enzank.countryapp.data.model.CountryDTO
import com.enzank.countryapp.data.model.CountryDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("all")
    suspend fun getCountryList():List<CountryDTO>;

    @GET("name/{country_name}")
    suspend fun getCountryDetails(
        @Path("country_name") countryName: String,
        @Query("format") format: String="json"
    ): CountryDetailsDTO

}