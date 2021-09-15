package com.example.coronaway.view.fragments

import androidx.lifecycle.*
import com.example.coronaway.data.repository.InfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(repository: InfoRepository) : ViewModel(){

    val information = repository.getInfo().asLiveData()

}