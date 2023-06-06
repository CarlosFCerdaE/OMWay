package com.main.omwayapp.apirest.model.trip

import java.time.LocalDate
import android.os.Parcelable
import com.main.omwayapp.apirest.model.omwayuser.DriverItem
import com.main.omwayapp.apirest.model.omwayuser.RiderItem
import com.main.omwayapp.apirest.model.vehicle.CarItem
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.sql.Time


data class RideItem(
    val id:Int,
    val pickUpTime: Time,
    val dropOffTime:Time,
    val pickUpLocation:String,
    val dropOffLocation:String,
    val distance:Double,
    val date:LocalDate,
    val notes:String,
    val state: String,
    val fare: Double,
    val rating:Int,
    val comment:String,
    val rider: RiderItem,
    val driver: DriverItem,
    val car: CarItem
)
