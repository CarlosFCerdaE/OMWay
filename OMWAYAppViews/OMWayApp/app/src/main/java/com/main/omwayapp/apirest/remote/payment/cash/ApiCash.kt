package com.main.omwayapp.apirest.remote.payment.cash

import com.main.omwayapp.apirest.dto.payment.cash.CashDto
import com.main.omwayapp.apirest.model.payment.cash.CashItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiCash {
    @GET("api/cash/all")
    suspend fun getAll():List<CashItem>

    @GET("api/cash/{id}")
    suspend fun findCashById(@Path("id")id:Int): CashItem

    @POST("api/cash/save")
    suspend fun save(@Body item: CashDto): CashDto

    @PUT("api/cash/update")
    suspend fun update(@Body item: CashDto): CashDto
}