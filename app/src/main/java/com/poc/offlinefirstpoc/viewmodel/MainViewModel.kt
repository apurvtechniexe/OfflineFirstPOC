package com.poc.offlinefirstpoc.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.poc.offlinefirstpoc.data.CountryResponse
import com.poc.offlinefirstpoc.repository.CountryRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val repository: CountryRepository = CountryRepository(application)

    var countryLiveData = MutableLiveData<CountryResponse>()

    init {
        viewModelScope.launch {
            getCountryDetails()
        }

    }


    suspend fun getCountryDetails() {
        repository.getCountryDetails()
        countryLiveData.value = repository.countryResponse.value
        /*    viewModelScope.launch {
                val country = withContext(Dispatchers.IO) {
                    repository.getCountryDetails()
                }
                countryLiveData.value = country
            }*/
    }
}