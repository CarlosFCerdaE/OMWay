package com.main.omwayapp.apirest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class ConfigFareItem(
    val id:Int,
    val fare:Double,
    val name:String,
    val state:Boolean
) : Parcelable
