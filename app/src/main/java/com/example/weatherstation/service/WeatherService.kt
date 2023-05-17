package com.example.weatherstation.service

import com.example.weatherstation.model.ReceivedData
import retrofit2.http.GET
import retrofit2.http.POST

interface WeatherService {

    @POST("/data")
    suspend fun getData(): ReceivedData
}