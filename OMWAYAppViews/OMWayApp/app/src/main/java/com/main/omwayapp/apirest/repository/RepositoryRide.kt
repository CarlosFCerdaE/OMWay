package com.main.omwayapp.apirest.repository

import android.util.Log
import com.main.omwayapp.apirest.model.RideItem
import com.main.omwayapp.apirest.remote.ApiAdapter
import com.main.omwayapp.apirest.remote.ApiRide

class RepositoryRide {
    private val apiRide: ApiRide = ApiAdapter.getInstance()
        .create(ApiRide::class.java)

    suspend fun save(rideItem: RideItem): RideItem {
        return apiRide.save(rideItem)
    }
    suspend fun update(rideItem: RideItem): RideItem {
        return apiRide.update(rideItem)
    }
}