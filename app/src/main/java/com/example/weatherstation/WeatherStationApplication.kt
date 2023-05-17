package com.example.weatherstation

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherStationApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherStationApplication)
            modules(
                listOf(
                    service,
                    viewModel
                )
            )
        }
    }
}