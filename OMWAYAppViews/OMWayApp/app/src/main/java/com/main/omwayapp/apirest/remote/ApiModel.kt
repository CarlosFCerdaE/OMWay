package com.main.omwayapp.apirest.remote

import com.main.omwayapp.apirest.dto.ModelDto
import com.main.omwayapp.apirest.model.ModelItem
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiModel {
    @GET("api/model/all")
    suspend fun getAll():List<ModelItem>

    @POST("api/model/save")
    suspend fun save(@Body item: ModelDto): ModelDto

    @PUT("api/model/update")
    suspend fun update(@Body item: ModelDto): ModelDto

    @DELETE("api/model/delete/{id}")
    suspend fun delete(@Path("id") id:Int) : Boolean
}