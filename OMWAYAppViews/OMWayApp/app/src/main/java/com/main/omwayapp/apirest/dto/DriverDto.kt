package com.main.omwayapp.apirest.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Parcelize
@Serializable
data class DriverDto(
    val driverCif: String,
    val password: String,
    val name: String,
    val phone: String,
    val email:String,
    val state: Boolean,
    @Contextual
    val dlExpirationDate: LocalDate
) : Parcelable