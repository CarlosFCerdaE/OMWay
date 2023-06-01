package com.main.omwayapp.apirest.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class PaymentCashDto(
    val paymentId: Int,
    val total: Double,
    val paymentMethod: String,
    val rideId:Int
) : Parcelable
