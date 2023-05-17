package com.example.weatherstation

import com.example.weatherstation.model.ReceivedData
import com.example.weatherstation.service.WeatherService
import com.example.weatherstation.viewmodel.WeatherViewModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


val service = module {
    single<OkHttpClient> { provideHttpClient() }
    single<Moshi> { provideMoshi() }
    single<Retrofit> { provideRetrofit(get(), get()) }
    single<WeatherService> { provideWeatherService(get()) }
}

val viewModel = module {
    viewModel { WeatherViewModel(get()) }
}

private fun provideRetrofit(moshi: Moshi, client: OkHttpClient) = Retrofit.Builder()
    .baseUrl(SERVER_URL)
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

private fun provideMoshi(): Moshi = Moshi.Builder().build()

private fun provideHttpClient(): OkHttpClient {
    val httpClient = OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
    return httpClient.build()
}

private fun provideWeatherService(retrofit: Retrofit): WeatherService =
    retrofit.create(WeatherService::class.java)

private const val SERVER_URL = "http://10.0.2.2:3000/"