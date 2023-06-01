package com.main.omwayapp.apirest.dto

import android.os.Parcelable
import com.main.omwayapp.apirest.model.DriverItem
import com.main.omwayapp.apirest.model.PaymentCashItem
import com.main.omwayapp.apirest.model.RiderItem
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.sql.Time
import java.time.LocalDate

@Parcelize
@Serializable
data class RideDto(
    val id:Int,
    @Contextual
    val pickUpTime: Time,
    @Contextual
    val dropOffTime: Time,
    val pickUpLocation:String,
    val dropOffLocation:String,
    val distance:Double,
    @Contextual
    val date: LocalDate,
    val notes:String,
    val state: String,
    val fare: Double,
    val rating:Int,
    val comment:String,
    val riderId: String,
    val driverId:String
) : Parcelable
