package com.enzank.countryapp.presentation.country_details

import com.enzank.countryapp.domain.model.CountryDetails

data class CountryDetailsState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: CountryDetails? = null
)
