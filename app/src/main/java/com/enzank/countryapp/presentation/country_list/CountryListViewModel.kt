package com.enzank.countryapp.presentation.country_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enzank.countryapp.common.Resource
import com.enzank.countryapp.domain.use_cases.GetCountryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(private val getCountryListUseCase: GetCountryListUseCase) :
    ViewModel() {

    init {
        getCountryList()
    }

    private val _list = mutableStateOf(CountryListState())
    val list: State<CountryListState> = _list;

    private fun getCountryList() {
        getCountryListUseCase().onEach {

            when (it) {
                is Resource.Error -> {
                    _list.value = CountryListState(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _list.value = CountryListState(isLoading = true)
                }
                is Resource.Success -> {
                    _list.value = CountryListState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}