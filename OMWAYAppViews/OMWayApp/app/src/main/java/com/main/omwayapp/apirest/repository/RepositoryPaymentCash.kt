package com.main.omwayapp.apirest.repository

import com.main.omwayapp.apirest.dto.PaymentCashDto
import com.main.omwayapp.apirest.model.PaymentCashItem
import com.main.omwayapp.apirest.remote.ApiAdapter
import com.main.omwayapp.apirest.remote.ApiPaymentCash

class RepositoryPaymentCash {
    private val apiPaymentCash: ApiPaymentCash = ApiAdapter.getInstance()
        .create(ApiPaymentCash::class.java)

    suspend fun getCashById(id:Int):PaymentCashItem{
        return apiPaymentCash.getCashById(id)
    }

    suspend fun save(paymentCashDto: PaymentCashDto): PaymentCashDto {
        return apiPaymentCash.save(paymentCashDto)
    }
    suspend fun update(paymentCashDto: PaymentCashDto): PaymentCashDto {
        return apiPaymentCash.update(paymentCashDto)
    }
}