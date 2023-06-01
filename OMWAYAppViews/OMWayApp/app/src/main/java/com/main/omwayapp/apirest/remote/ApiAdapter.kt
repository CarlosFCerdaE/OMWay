package com.main.omwayapp.apirest.remote

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiAdapter {

    private lateinit var applicationContext: Context

    fun initialize(context: Context) {
        applicationContext = context.applicationContext
    }
    val BASE_URL = "http://192.168.1.6:8181"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }
}