package com.main.omwayapp.apirest.repository.payment.cash

import com.main.omwayapp.apirest.dto.payment.cash.CashDto
import com.main.omwayapp.apirest.model.payment.cash.CashItem
import com.main.omwayapp.apirest.remote.ApiAdapter
import com.main.omwayapp.apirest.remote.payment.cash.ApiCash

class RepositoryCash {
    private val apiCash: ApiCash = ApiAdapter.getInstance()
        .create(ApiCash::class.java)

    suspend fun findCashById(id:Int): CashItem {
        return apiCash.findCashById(id)
    }

    suspend fun save(cashDto: CashDto): CashDto {
        return apiCash.save(cashDto)
    }
    suspend fun update(cashDto: CashDto): CashDto {
        return apiCash.update(cashDto)
    }
}