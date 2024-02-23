package com.example.mvvm.retrofit

import com.example.mvvm.data.WeatherData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String?,
        @Query("appid") apiKey: String?,
        @Query("units") units: String,
        @Query("lang") lang: String
    ):WeatherData
}

object RetrofitClient {
    private val baseUrl = "https://api.openweathermap.org/data/2.5/"

    fun createService(): RetrofitServices {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitServices::class.java)
    }
}

