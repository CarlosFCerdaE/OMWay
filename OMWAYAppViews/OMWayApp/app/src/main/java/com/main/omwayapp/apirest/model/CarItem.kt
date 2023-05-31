package com.main.omwayapp.apirest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class CarItem(
    val licensePlate:String,
    val color:String,
    val year:String,
    val state:Boolean,
    val driver:DriverItem,
    val model:ModelItem
) : Parcelable
