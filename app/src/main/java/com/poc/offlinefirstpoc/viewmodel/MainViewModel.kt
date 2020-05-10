package com.poc.offlinefirstpoc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poc.offlinefirstpoc.data.CountryResponse
import com.poc.offlinefirstpoc.repository.CountryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    val repository: CountryRepository = CountryRepository()

    val countryLiveData = MutableLiveData<CountryResponse>()

    init {

        getCountryDetails()
    }


    fun getCountryDetails() {
        viewModelScope.launch {
            val country = withContext(Dispatchers.IO) {
                repository.getCountryDetails()
            }
            countryLiveData.value = country
        }
    }
}