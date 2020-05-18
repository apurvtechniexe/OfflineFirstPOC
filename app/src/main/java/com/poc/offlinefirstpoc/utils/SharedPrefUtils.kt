package com.poc.offlinefirstpoc.utils

import android.content.Context
import android.content.SharedPreferences


class SharedPrefUtils(context: Context) {
    private var editor: SharedPreferences.Editor
    private var mSharedPreferences: SharedPreferences

    init {

        mSharedPreferences = context.getSharedPreferences("DEMO_OFFLINE", Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
    }


    fun storeStringInSharedPref(key: String?, value: String?) {
        editor.putString(key, value)
        editor.commit()
    }

    fun getStringFromSharedPref(key: String?): String? {
        return mSharedPreferences.getString(key, "")
    }

    companion object {

        val COUNTRY_RESPONSE = "COUNTRY_RESPONSE"
    }

}