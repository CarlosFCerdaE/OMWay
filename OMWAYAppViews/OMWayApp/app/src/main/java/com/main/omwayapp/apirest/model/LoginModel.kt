package com.main.omwayapp.apirest.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.main.omwayapp.apirest.repository.RepositoryUser
import com.main.omwayapp.apirest.response.LoginResponse

class LoginModel : ViewModel() {
    var cif by mutableStateOf("")
    var password by mutableStateOf("")

    fun onSummit() : LoginResponse {
        Log.d("Valores","Valor cif:$cif, valor Password: $password")
        val repository = RepositoryUser()
        return repository.fetchData(cif,password);
    }
}