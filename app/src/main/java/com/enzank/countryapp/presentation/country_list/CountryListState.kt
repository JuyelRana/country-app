package com.enzank.countryapp.presentation.country_list

import com.enzank.countryapp.domain.model.Country

data class CountryListState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Country>? = null
)
