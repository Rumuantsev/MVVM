package com.example.mvvm.data

data class WeatherData(
    var coord: Coord,
    var weather: List<Weather>,
    var base: String,
    var main: Main,
    var visibility: Int,
    var wind: Wind,
    var rain: Rain,
    var clouds: Clouds,
    var dt: Long,
    var sys: Sys,
    var timezone: Int,
    var id: Long,
    var name: String,
    var cod: Int
)


data class Coord(
    var lon: Double,
    var lat: Double
)

data class Weather(
    var id: Int,
    var main: String,
    var description: String,
    var icon: String
)

data class Main(
    var temp: Double,
    var feelsLike: Double,
    var tempMin: Double,
    var tempMax: Double,
    var pressure: Int,
    var humidity: Int
)

data class Wind(
    var speed: Double,
    var deg: Int,
    var gust: Double
)

data class Rain(
    var h1: Double
)

data class Clouds(
    var all: Int
)

data class Sys(
    var type: Int,
    var id: Int,
    var country: String,
    var sunrise: Long,
    var sunset: Long
)

