package com.main.omwayapp.apirest.repository

import com.main.omwayapp.apirest.model.CarItem
import com.main.omwayapp.apirest.remote.ApiAdapter
import com.main.omwayapp.apirest.remote.ApiCar

class RepositoryCar {
    private val apiCar:ApiCar = ApiAdapter.getInstance()
        .create(ApiCar::class.java)

    suspend fun save(carItem: CarItem):CarItem{
            return apiCar.save(carItem)
    }
    suspend fun update(carItem: CarItem):CarItem{
        return apiCar.update(carItem)
    }
    suspend fun delete(id:String):Boolean{
        return apiCar.delete(id)
    }
}