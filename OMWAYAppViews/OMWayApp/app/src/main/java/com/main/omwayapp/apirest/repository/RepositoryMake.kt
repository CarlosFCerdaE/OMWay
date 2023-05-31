package com.main.omwayapp.apirest.repository

import android.util.Log
import com.main.omwayapp.apirest.model.MakeItem
import com.main.omwayapp.apirest.remote.ApiAdapter
import com.main.omwayapp.apirest.remote.ApiMake

class RepositoryMake {
    private val apiMake: ApiMake = ApiAdapter.getInstance()
        .create(ApiMake::class.java)

    suspend fun getAll():List<MakeItem>{
        try {
            return apiMake.getAll()
        } catch (e: Exception) {
            Log.d("ERROR", e.message.toString())
        }
        return emptyList<MakeItem>()
    }

    suspend fun save(makeItem: MakeItem): MakeItem {
        return apiMake.save(makeItem)
    }
    suspend fun update(makeItem: MakeItem): MakeItem {
        return apiMake.update(makeItem)
    }
    suspend fun delete(id:Int):Boolean{
        return apiMake.delete(id)
    }
}