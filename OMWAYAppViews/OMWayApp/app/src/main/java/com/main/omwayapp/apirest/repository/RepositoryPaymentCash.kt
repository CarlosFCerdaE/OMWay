package com.main.omwayapp.apirest.repository

import com.main.omwayapp.apirest.model.PaymentCashItem
import com.main.omwayapp.apirest.remote.ApiAdapter
import com.main.omwayapp.apirest.remote.ApiPaymentCash

class RepositoryPaymentCash {
    private val apiPaymentCash: ApiPaymentCash = ApiAdapter.getInstance()
        .create(ApiPaymentCash::class.java)

    suspend fun getCashById(id:Int):PaymentCashItem{
        return apiPaymentCash.getCashById(id)
    }

    suspend fun save(paymentCashItem: PaymentCashItem): PaymentCashItem {
        return apiPaymentCash.save(paymentCashItem)
    }
    suspend fun update(paymentCashItem: PaymentCashItem): PaymentCashItem {
        return apiPaymentCash.update(paymentCashItem)
    }
}