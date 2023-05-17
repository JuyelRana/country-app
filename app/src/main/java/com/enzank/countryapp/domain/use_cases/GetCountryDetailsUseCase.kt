package com.enzank.countryapp.domain.use_cases

import com.enzank.countryapp.common.Resource
import com.enzank.countryapp.domain.model.CountryDetails
import com.enzank.countryapp.domain.repository.CountryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCountryDetailsUseCase(private val countryRepository: CountryRepository) {
    operator fun invoke(countryName: String): Flow<Resource<CountryDetails>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = countryRepository.getCountryDetails(countryName = countryName)))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}