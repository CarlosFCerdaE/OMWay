package com.main.omwayapp.apirest.model.payment.cash

import android.os.Parcelable
import com.main.omwayapp.apirest.model.trip.RideItem
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class CashItem(
    val paymentId: Int,
    val total: Double,
    val paymentMethod: String,
    val ride: RideItem
) : Parcelable
