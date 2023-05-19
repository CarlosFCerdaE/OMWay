package com.main.omwayapp.apirest.model

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.main.omwayapp.apirest.repository.RepositoryUser
import com.main.omwayapp.apirest.response.LoginResponse

class LoginModel : ViewModel() {
    private val _cif = mutableStateOf("")
    val cif: MutableState<String> get() = _cif

    private val _password = mutableStateOf("")
    val password: MutableState<String> get() = _password

    fun onSummit(context: Context) : LoginResponse {
        Log.d("Valores","Valor cif:${cif.value}, valor Password: ${password.value}")
        val repository = RepositoryUser()
        return repository.fetchData(context,cif.value,password.value)
    }
}