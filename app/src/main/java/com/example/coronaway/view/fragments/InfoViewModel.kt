package com.example.coronaway.view.fragments

import androidx.lifecycle.*
import com.example.coronaway.data.repository.CountryRepository
import com.example.coronaway.data.repository.DataRepository
import com.example.coronaway.utils.Resource
import com.example.coronaway.view.models.Country
import com.example.coronaway.view.models.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(dataRepository: DataRepository, countryRepository: CountryRepository) : ViewModel(){

    private val _data = dataRepository.getData().asLiveData(viewModelScope.coroutineContext)
    private val _countries = countryRepository.getCountry().asLiveData(viewModelScope.coroutineContext)

    val data: LiveData<Resource<Data>>
            get() = _data

    val country: LiveData<Resource<List<Country>>>
            get() = _countries

}