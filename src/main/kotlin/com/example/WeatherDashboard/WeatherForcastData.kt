package com.example.WeatherDashboard

data class WeatherForecastData(
    val city_name: String,
    val forecast: List<ForecastTemperature>,
    val country_code: String,
    val state_code: String
)

data class ForecastTemperature(
    val date: String,
    val temperature: Double
)
