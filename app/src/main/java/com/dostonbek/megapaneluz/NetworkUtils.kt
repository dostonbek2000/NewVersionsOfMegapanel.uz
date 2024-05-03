package com.dostonbek.megapaneluz

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkUtils {
    fun isNetworkAvailable(context: Context):Boolean{
        val connectivityManager=context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val activeNetworkInfo:NetworkInfo?=connectivityManager?.activeNetworkInfo
        return activeNetworkInfo!=null && activeNetworkInfo.isConnected
    }

}