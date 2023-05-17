package com.enzank.countryapp.data.model

data class CountryDetailsDTO(
    val country: CountryDTO?,
    val currency: CurrencyDTO?,
    val flag: FlagDTO?,
    val population: String? = null,
    val region: String? = null,
    val timezone: TimeZoneDTO?
)
