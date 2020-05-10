package com.poc.offlinefirstpoc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.poc.offlinefirstpoc.R
import com.poc.offlinefirstpoc.data.CountryResponse
import com.poc.offlinefirstpoc.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.countryLiveData.observe(this, Observer {
            setAdapter(it)

        })

    }

    fun setAdapter(countryResponse: CountryResponse) {
        countryListRV.adapter = CountryDetailsAdapter(this, countryResponse.rows)
    }
}
