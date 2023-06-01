package com.main.omwayapp.apirest.remote

import com.main.omwayapp.apirest.dto.RideDto
import retrofit2.http.Body

import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiRide {

    @POST("api/ride/save")
    suspend fun save(@Body item: RideDto): RideDto

    @PUT("api/ride/update")
    suspend fun update(@Body item: RideDto): RideDto
}