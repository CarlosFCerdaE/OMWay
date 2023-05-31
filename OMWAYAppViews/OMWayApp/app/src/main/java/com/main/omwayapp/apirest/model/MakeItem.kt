package com.main.omwayapp.apirest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class MakeItem(
    val id:Int,
    val name:String,
    val makeModels:List<ModelItem>
) : Parcelable
