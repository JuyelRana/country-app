package com.enzank.countryapp.domain.model

data class CountryDetails(
    val country: Country?,
    val currency: Currency?,
    val flag: Flag?,
    val population: String? = null,
    val region: String? = null,
    val timezone: TimeZone?
)
