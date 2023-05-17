package com.example.weatherstation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherstation.model.ReceivedData
import com.example.weatherstation.service.WeatherService
import kotlinx.coroutines.launch

class WeatherViewModel(private val weatherService: WeatherService) : ViewModel() {
    private val _receivedData: MutableLiveData<ReceivedData> = MutableLiveData()
    val receivedData: LiveData<ReceivedData>
        get() = _receivedData

    fun getData() {
        viewModelScope.launch() {
            _receivedData.value = weatherService.getData()
            println("Value:" + _receivedData.value?.toString())
        }
    }
}