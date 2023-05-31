package com.main.omwayapp.apirest.model

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.omwayapp.apirest.repository.RepositoryUser
import com.main.omwayapp.apirest.response.LoginResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginModel : ViewModel() {
    private val _cif = mutableStateOf("")
    val cif: MutableState<String> get() = _cif

    private val _password = mutableStateOf("")
    val password: MutableState<String> get() = _password

    var _state = MutableStateFlow(UIState())
    val state : StateFlow<UIState> = _state.asStateFlow()

    val repository = RepositoryUser()

    data class UIState(
        val _loading: Boolean = false,
        val loginResponse: LoginResponse = LoginResponse()
    )

    fun onSummit(){
        viewModelScope.launch{
            _state.update { it.copy(_loading = true) }
            val login = repository.fetchData(cif.value,password.value).getOrDefault(LoginResponse())
            _state.update { it.copy(loginResponse = login) }
            _state.update { it.copy(_loading = false) }
        }
    }
}