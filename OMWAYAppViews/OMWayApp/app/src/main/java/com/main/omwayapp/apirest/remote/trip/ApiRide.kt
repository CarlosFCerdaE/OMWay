package com.main.omwayapp.apirest.remote.trip

import com.main.omwayapp.apirest.dto.trip.RideDto
import retrofit2.http.Body

import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiRide {

    @POST("api/ride/save")
    suspend fun save(@Body item: RideDto): RideDto

    @PUT("api/ride/update")
    suspend fun update(@Body item: RideDto): RideDto
}