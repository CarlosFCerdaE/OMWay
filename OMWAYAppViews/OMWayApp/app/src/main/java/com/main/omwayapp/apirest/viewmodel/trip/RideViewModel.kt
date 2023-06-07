package com.main.omwayapp.apirest.viewmodel.trip

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.omwayapp.apirest.model.trip.RideItem
import com.main.omwayapp.apirest.model.vehicle.ModelItem
import com.main.omwayapp.apirest.repository.trip.RepositoryRide
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
class RideViewModel:ViewModel() {
    @RequiresApi(Build.VERSION_CODES.O)
    private val repositoryRide : RepositoryRide = RepositoryRide()

    private val _rideState = MutableStateFlow<RideListUIState>(RideListUIState())
    val rideState: StateFlow<RideListUIState> = _rideState


    fun findInProgressRidesByRiderCif(cif:String){
        viewModelScope.launch {
            _rideState.update {it.copy(_loading = true)}
            val response = repositoryRide.findInProgressRidesByRiderCif(cif)
            _rideState.update {it.copy(listModel = response)}
            _rideState.update {it.copy(_loading = false)}
        }
    }
    fun findDiscontinuedRideByRiderCif(cif:String){
        viewModelScope.launch {
            _rideState.update {it.copy(_loading = true)}
            val response = repositoryRide.findDiscontinuedRideByRiderCif(cif)
            _rideState.update {it.copy(listModel = response)}
            _rideState.update {it.copy(_loading = false)}
        }
    }
    fun findInProgressRidesByDriverCif(cif:String){
        viewModelScope.launch {
            _rideState.update {it.copy(_loading = true)}
            val response = repositoryRide.findInProgressRidesByDriverCif(cif)
            _rideState.update {it.copy(listModel = response)}
            _rideState.update {it.copy(_loading = false)}
        }
    }
    fun findDiscontinuedRidesByDriverCif(cif:String){
        viewModelScope.launch {
            _rideState.update {it.copy(_loading = true)}
            val response = repositoryRide.findDiscontinuedRidesByDriverCif(cif)
            _rideState.update {it.copy(listModel = response)}
            _rideState.update {it.copy(_loading = false)}
        }
    }
    fun getRequestedRides(){
        viewModelScope.launch {
            _rideState.update {it.copy(_loading = true)}
            val response = repositoryRide.getRequestedRides()
            _rideState.update {it.copy(listModel = response)}
            _rideState.update {it.copy(_loading = false)}
        }
    }


    data class RideListUIState(
        val _loading:Boolean = false,
        val listModel:List<RideItem> = emptyList()
    )
}