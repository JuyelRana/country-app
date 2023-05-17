package com.enzank.countryapp.domain.use_cases

import com.enzank.countryapp.common.Resource
import com.enzank.countryapp.domain.model.Country
import com.enzank.countryapp.domain.repository.CountryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCountryListUseCase(private val countryRepository: CountryRepository) {
    operator fun invoke(): Flow<Resource<List<Country>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = countryRepository.getCountryList()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}