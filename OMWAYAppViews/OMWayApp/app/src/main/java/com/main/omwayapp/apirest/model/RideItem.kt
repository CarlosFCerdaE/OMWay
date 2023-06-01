package com.main.omwayapp.apirest.model

import java.sql.Time
import java.time.LocalDate
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class RideItem(
    val id:Int,
    @Contextual
    val pickUpTime: Time,
    @Contextual
    val dropOffTime:Time,
    val pickUpLocation:String,
    val dropOffLocation:String,
    val distance:Double,
    @Contextual
    val date:LocalDate,
    val notes:String,
    val state: String,
    val fare: Double,
    val rating:Int,
    val comment:String,
    val rider:RiderItem,
    val driver:DriverItem
) : Parcelable
