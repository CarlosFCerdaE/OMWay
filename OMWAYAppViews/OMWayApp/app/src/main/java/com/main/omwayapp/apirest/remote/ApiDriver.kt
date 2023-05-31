package com.main.omwayapp.apirest.remote

import com.main.omwayapp.apirest.model.DriverItem
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiDriver {
    @GET("api/driver/all")
    suspend fun getAll():List<DriverItem>

    @POST("api/driver/save")
    suspend fun save(@Body item: DriverItem): DriverItem

    @PUT("api/driver/update")
    suspend fun update(@Body item: DriverItem): DriverItem

    @DELETE("api/driver/delete/{cif}")
    suspend fun delete(@Path("cif") cif:String) : Boolean
}