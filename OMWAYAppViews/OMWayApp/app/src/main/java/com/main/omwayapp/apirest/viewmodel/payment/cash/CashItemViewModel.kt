package com.main.omwayapp.apirest.viewmodel.payment.cash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.omwayapp.apirest.dto.payment.cash.CashDto
import com.main.omwayapp.apirest.repository.payment.cash.RepositoryCash
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CashItemViewModel:ViewModel() {
    val repositoryCash : RepositoryCash = RepositoryCash()

    var _cashState = MutableStateFlow(false)
    val cashState : StateFlow<Boolean> = _cashState

    init {
        viewModelScope.launch {
            _cashState.update {false}
        }
    }

    fun saveCash(item: CashDto){
        viewModelScope.launch {
            repositoryCash.save(item)
            _cashState.update {true}
        }
    }

    fun updateCash(item: CashDto){
        viewModelScope.launch {
            repositoryCash.update(item)
            _cashState.update {true}
        }
    }
}