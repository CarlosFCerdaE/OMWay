package com.main.omwayapp.apirest.viewmodel.payment.cash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.omwayapp.apirest.model.payment.cash.CashItem
import com.main.omwayapp.apirest.repository.payment.cash.RepositoryCash
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CashViewModel: ViewModel() {
    private val repositoryCash : RepositoryCash = RepositoryCash()

    private val _cashState = MutableStateFlow<CashUIState>(CashUIState())
    val cashState: StateFlow<CashUIState> = _cashState

    fun findCashById(item:Int){
        viewModelScope.launch {
            _cashState.update {it.copy(_loading = true)}
            val response = repositoryCash.findCashById(item)
            _cashState.update {it.copy(cashItem = response)}
            _cashState.update {it.copy(_loading = false)}
        }
    }

    data class CashUIState(
        val _loading:Boolean = false,
        val cashItem:CashItem? = null
    )
}