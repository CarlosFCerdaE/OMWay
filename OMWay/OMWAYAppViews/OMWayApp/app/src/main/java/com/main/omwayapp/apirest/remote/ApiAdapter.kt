package com.main.omwayapp.apirest.remote

import android.content.Context
import android.content.pm.PackageManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiAdapter {

    private lateinit var applicationContext: Context

    fun initialize(context: Context) {
        applicationContext = context.applicationContext
    }

    /* val BASE_URL: String
         get() {
             try {
                 val appInfo = applicationContext.packageManager.getApplicationInfo(
                     applicationContext.packageName,
                     PackageManager.GET_META_DATA
                 )
                 val metaData = appInfo.metaData
                 return metaData.getString("BASE_URL").toString()
             } catch (e: PackageManager.NameNotFoundException) {
                 e.printStackTrace()
             }
             return ""
         }
 */
    val BASE_URL = "http://192.168.1.6:8181"

    fun getInstance(): Retrofit {

        val client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}