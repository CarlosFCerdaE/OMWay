package com.main.omwayapp.apirest.repository

import android.util.Log
import com.main.omwayapp.apirest.model.PaymentCashItem
import com.main.omwayapp.apirest.remote.ApiAdapter
import com.main.omwayapp.apirest.remote.ApiPaymentCash

class RepositoryPaymentCash {
    private val apiPaymentCash: ApiPaymentCash = ApiAdapter.getInstance()
        .create(ApiPaymentCash::class.java)

    suspend fun getAll():List<PaymentCashItem>{
        try {
            return apiPaymentCash.getAll()
        } catch (e: Exception) {
            Log.d("ERROR", e.message.toString())
        }
        return emptyList<PaymentCashItem>()
    }
    suspend fun getCashById(id:Int):PaymentCashItem{
        return apiPaymentCash.getCashById(id)
    }

    suspend fun save(configFareItem: PaymentCashItem): PaymentCashItem {
        return apiPaymentCash.save(configFareItem)
    }
    suspend fun update(configFareItem: PaymentCashItem): PaymentCashItem {
        return apiPaymentCash.update(configFareItem)
    }
}