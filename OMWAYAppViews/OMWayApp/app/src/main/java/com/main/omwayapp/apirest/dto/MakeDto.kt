package com.main.omwayapp.apirest.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class MakeDto(
    val id:Int,
    val name:String
) : Parcelable
