package com.poc.offlinefirstpoc.repository

import com.poc.offlinefirstpoc.network.RetrofitClient

class CountryRepository {

    var client = RetrofitClient.getService()

    suspend fun getCountryDetails() = client.getCountryDetails()
}