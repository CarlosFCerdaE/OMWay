package com.main.omwayapp.apirest.model

import java.time.LocalDate
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class DriverItem(
    val cif: String,
    val password: String,
    val name: String,
    val phone: String,
    val email:String,
    val state: Boolean,
    @Contextual
    val dlExpirationDate:LocalDate,
    val sumRating:Int,
    val numberRides:Int,
    val driverCars: List<CarItem>,
    val driverRides:List<RideItem>

) : Parcelable
