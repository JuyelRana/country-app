package com.enzank.countryapp.common

import com.enzank.countryapp.data.model.*
import com.enzank.countryapp.domain.model.*

fun CountryDetailsDTO.toDomain(): CountryDetails {
    return CountryDetails(
        country = country?.toDomain() ?: Country(name = CountryName("", ""), ""),
        currency = currency?.toDomain() ?: Currency("", ""),
        flag = flag?.toDomain() ?: Flag("", "", ""),
        population = population ?: "",
        region = region ?: "",
        timezone = timezone?.toDomain() ?: TimeZone("")
    )
}

fun CountryDTO.toDomain(): Country {
    return Country(
        name = name?.toDomain() ?: CountryName("", ""),
        url = url ?: ""
    )
}

fun CountryNameDTO.toDomain(): CountryName {
    return CountryName(
        common = common ?: "",
        official = official ?: ""
    )
}

fun CurrencyDTO.toDomain(): Currency {
    return Currency(
        name = name ?: "",
        symbol = symbol ?: ""
    )
}

fun FlagDTO.toDomain(): Flag {
    return Flag(
        png = png ?: "",
        svg = svg ?: "",
        alt = alt ?: ""
    )
}

fun TimeZoneDTO.toDomain(): TimeZone {
    return TimeZone(
        name = name ?: ""
    )
}