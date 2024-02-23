package com.example.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewmodel.WeatherViewModel
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    lateinit var weatherViewModel: WeatherViewModel
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        bindingClass.buttonGet.setOnClickListener() {
            weatherViewModel.APIquery(bindingClass.inputCity.text.toString())
        }

        weatherViewModel.weatherData.observe(this) { weatherData ->
            bindingClass.tVTemp.text = weatherData.main.temp.toString()
            bindingClass.tVDescription.text = weatherData.weather[0].description
            bindingClass.tVCity.text = weatherData.name
            Picasso.get().load("https://openweathermap.org/img/wn/" + weatherData.weather[0].icon + "@2x.png").into(bindingClass.image)
        }
    }
}
