package com.example.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.data.WeatherData
import com.example.mvvm.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class WeatherViewModel : ViewModel() {
    private val apiService = RetrofitClient.createService()
    val weatherData = MutableLiveData<WeatherData>()

    fun APIquery(city : String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getCurrentWeather(city, "4518e07f5c7de659bd2a9f39cee1c8d5", "metric", "ru")
                withContext(Dispatchers.Main) {
                    weatherData.postValue(response)
                }
            } catch (ex : Exception) { }
        }
    }
}