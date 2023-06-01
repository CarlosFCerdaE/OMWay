package com.main.omwayapp.apirest.model

import android.os.Parcelable
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
