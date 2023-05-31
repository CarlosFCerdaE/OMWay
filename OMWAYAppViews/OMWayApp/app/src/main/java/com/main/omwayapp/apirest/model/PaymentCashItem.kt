package com.main.omwayapp.apirest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class PaymentCashItem(
    val paymentId: Int,
    val total: Double,
    val paymentMethod: String,
    val ride: RideItem
) : Parcelable
