package com.main.omwayapp.apirest.repository

import android.util.Log
import com.main.omwayapp.apirest.remote.ApiAdapter
import com.main.omwayapp.apirest.remote.ApiUser
import com.main.omwayapp.apirest.response.LoginResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Response

class RepositoryUser : CoroutineScope by MainScope() {
    val apiUser : ApiUser = ApiAdapter.getInstance()
        .create(ApiUser::class.java)

    fun fetchData(cif: String, password: String): LoginResponse {
        var  loginResponse : LoginResponse = LoginResponse()
        launch {
            try {
                val response: Response<LoginResponse> = apiUser.getLogin(cif, password)
                if (response.isSuccessful) {
                    loginResponse = response.body() as LoginResponse
                    Log.d("RESULTADO OK","RESULTADO OK,$loginResponse.msg")
                } else {
                    loginResponse.msg = "Sin exito"
                    loginResponse.success=false
                    Log.d("RESULTADO OK","RESULTADO OK,$loginResponse.msg")
                }
            } catch (e: Exception) {
                Log.d("ERRORCUSTOM", "$e.message")
            }
        }
        return loginResponse;
    }
}