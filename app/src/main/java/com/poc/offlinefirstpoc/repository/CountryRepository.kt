package com.poc.offlinefirstpoc.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.poc.offlinefirstpoc.data.CountryResponse
import com.poc.offlinefirstpoc.network.RetrofitClient
import com.poc.offlinefirstpoc.utils.SharedPrefUtils
import com.poc.offlinefirstpoc.utils.Utils

class CountryRepository(val application: Application) {

    var client = RetrofitClient.getService()
    var countryResponse = MutableLiveData<CountryResponse>()

    suspend fun getCountryDetails() {

        val sharePref = SharedPrefUtils(application.applicationContext)
        val countryResString = sharePref.getStringFromSharedPref(SharedPrefUtils.COUNTRY_RESPONSE)
        val gson = Gson()
        if (countryResString?.isNotEmpty() ?: false) {


            var testModel = gson.fromJson(countryResString, CountryResponse::class.java)
            countryResponse.value = testModel


        }
        if (Utils().checkConnectivity(application)) {
            val response = client.getCountryDetails()
            val jsonString = gson.toJson(response)
            sharePref.storeStringInSharedPref(SharedPrefUtils.COUNTRY_RESPONSE, jsonString)
            countryResponse.value = response
        }


        //
    }
}