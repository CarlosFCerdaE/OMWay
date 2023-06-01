package com.main.omwayapp.apirest.repository

import android.util.Log
import com.main.omwayapp.apirest.dto.DriverDto
import com.main.omwayapp.apirest.model.DriverItem
import com.main.omwayapp.apirest.remote.ApiAdapter
import com.main.omwayapp.apirest.remote.ApiDriver
import java.lang.Exception

class RepositoryDriver {
    private val apiDriver: ApiDriver = ApiAdapter.getInstance()
        .create(ApiDriver::class.java)

    suspend fun getAll():List<DriverItem>{
        try {
            return apiDriver.getAll()
        } catch (e: Exception) {
            Log.d("ERROR", e.message.toString())
        }
        return emptyList<DriverItem>()
    }
    suspend fun findByCif(cif:String):DriverItem{
        return apiDriver.findByCif(cif)
    }

    suspend fun save(driverDto: DriverDto): DriverDto {
        return apiDriver.save(driverDto)
    }
    suspend fun update(driverDto: DriverDto): DriverDto {
        return apiDriver.update(driverDto)
    }
    suspend fun delete(cif:String):Boolean{
        return apiDriver.delete(cif)
    }
}