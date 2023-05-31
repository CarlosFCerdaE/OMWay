package com.main.omwayapp.apirest.remote

import com.main.omwayapp.apirest.model.DriverItem
import com.main.omwayapp.apirest.model.RiderItem
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiRider {
    @GET("api/rider/all")
    suspend fun getAll():List<RiderItem>

    @POST("api/rider/save")
    suspend fun save(@Body item: RiderItem): RiderItem

    @PUT("api/rider/update")
    suspend fun update(@Body item: RiderItem): RiderItem

    @DELETE("api/rider/delete/{cif}")
    suspend fun delete(@Path("cif") cif:String) : Boolean
}