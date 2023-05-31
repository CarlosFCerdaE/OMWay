package com.main.omwayapp.apirest.remote

import com.main.omwayapp.apirest.model.PaymentCashItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiPaymentCash {
    @GET("api/cash/all")
    suspend fun getAll():List<PaymentCashItem>

    @GET("api/cash/{id}")
    suspend fun getCashById(@Path("id")id:Int):PaymentCashItem

    @POST("api/cash/save")
    suspend fun save(@Body item: PaymentCashItem): PaymentCashItem

    @PUT("api/cash/update")
    suspend fun update(@Body item: PaymentCashItem): PaymentCashItem
}