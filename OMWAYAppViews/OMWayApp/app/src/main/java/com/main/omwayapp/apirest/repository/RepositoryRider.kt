package com.main.omwayapp.apirest.repository

import android.util.Log
import com.main.omwayapp.apirest.model.RiderItem
import com.main.omwayapp.apirest.remote.ApiAdapter
import com.main.omwayapp.apirest.remote.ApiRider

class RepositoryRider {
    private val apiRider: ApiRider = ApiAdapter.getInstance()
        .create(ApiRider::class.java)

    suspend fun getAll():List<RiderItem>{
        try {
            return apiRider.getAll()
        } catch (e: Exception) {
            Log.d("ERROR", e.message.toString())
        }
        return emptyList<RiderItem>()
    }

    suspend fun save(configFareItem: RiderItem): RiderItem {
        return apiRider.save(configFareItem)
    }
    suspend fun update(configFareItem: RiderItem): RiderItem {
        return apiRider.update(configFareItem)
    }
    suspend fun delete(cif:String):Boolean{
        return apiRider.delete(cif)
    }
}