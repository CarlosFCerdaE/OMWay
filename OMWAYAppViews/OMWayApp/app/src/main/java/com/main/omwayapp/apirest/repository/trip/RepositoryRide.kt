package com.main.omwayapp.apirest.repository.trip

import com.main.omwayapp.apirest.dto.trip.RideDto
import com.main.omwayapp.apirest.remote.ApiAdapter
import com.main.omwayapp.apirest.remote.trip.ApiRide

class RepositoryRide {
    private val apiRide: ApiRide = ApiAdapter.getInstance()
        .create(ApiRide::class.java)

    suspend fun save(rideDto: RideDto): RideDto {
        return apiRide.save(rideDto)
    }
    suspend fun update(rideDto: RideDto): RideDto {
        return apiRide.update(rideDto)
    }
}