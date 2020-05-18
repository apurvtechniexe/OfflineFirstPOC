package com.poc.offlinefirstpoc.utils

import android.content.Context
import android.net.ConnectivityManager

class Utils {
    fun checkConnectivity(act: Context?): Boolean {
        try {
            val cm = act?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = cm.activeNetworkInfo
            if (cm == null) {
                return false
            } else if (info == null) {
                return false
            } else if (info.isConnectedOrConnecting) {
                return true
            }
        } catch (e: Exception) {
        }

        return false
    }
}