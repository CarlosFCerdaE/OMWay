package com.main.omwayapp.apirest.repository

import android.util.Log
import com.main.omwayapp.apirest.dto.ModelDto
import com.main.omwayapp.apirest.model.ModelItem
import com.main.omwayapp.apirest.remote.ApiAdapter
import com.main.omwayapp.apirest.remote.ApiModel

class RepositoryModel {
    private val apiModel: ApiModel = ApiAdapter.getInstance()
        .create(ApiModel::class.java)

    suspend fun getAll():List<ModelItem>{
        try {
            return apiModel.getAll()
        } catch (e: Exception) {
            Log.d("ERROR", e.message.toString())
        }
        return emptyList<ModelItem>()
    }

    suspend fun save(modelDto: ModelDto): ModelDto {
        return apiModel.save(modelDto)
    }
    suspend fun update(modelDto: ModelDto): ModelDto {
        return apiModel.update(modelDto)
    }
    suspend fun delete(id:Int):Boolean{
        return apiModel.delete(id)
    }
}