package com.main.omwayapp.apirest.model.omwayuser

import android.os.Parcelable
import com.main.omwayapp.apirest.model.trip.RideItem
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class RiderItem(
    val cif: String,
    val password: String,
    val name: String,
    val phone: String,
    val email:String,
    val state: Boolean,
    val riderRides: List<RideItem>
) : Parcelable
