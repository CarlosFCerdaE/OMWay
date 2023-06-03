package com.main.omwayapp.apirest.viewmodel.vehicle.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.omwayapp.apirest.model.vehicle.ModelItem
import com.main.omwayapp.apirest.repository.vehicle.RepositoryModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ModelViewModel:ViewModel() {
    private val repositoryModel : RepositoryModel = RepositoryModel()

    private val _modelState = MutableStateFlow<ModelListUIState>(ModelListUIState())
    val modelState: StateFlow<ModelListUIState> = _modelState


    fun getAllModel(){
        viewModelScope.launch {
            _modelState.update {it.copy(_loading = true)}
            val response = repositoryModel.getAll()
            _modelState.update {it.copy(listModel = response)}
            _modelState.update {it.copy(_loading = false)}
        }
    }

    data class ModelListUIState(
        val _loading:Boolean = false,
        val listModel:List<ModelItem> = emptyList()
    )
}