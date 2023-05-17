package com.example.weatherstation.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class ReceivedData(
    @Json(name = "temperature")
    val temperature: String,
    @Json(name = "humidity")
    var humidity: String,
) : Parcelable