package com.main.omwayapp.apirest.repository

import com.main.omwayapp.apirest.dto.CarDto
import com.main.omwayapp.apirest.remote.ApiAdapter
import com.main.omwayapp.apirest.remote.ApiCar

class RepositoryCar {
    private val apiCar:ApiCar = ApiAdapter.getInstance()
        .create(ApiCar::class.java)

    suspend fun save(carDto: CarDto):CarDto{
            return apiCar.save(carDto)
    }
    suspend fun update(carDto: CarDto):CarDto{
        return apiCar.update(carDto)
    }
    suspend fun delete(id:String):Boolean{
        return apiCar.delete(id)
    }
}