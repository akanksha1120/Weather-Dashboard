package com.example.WeatherDashboard

data class WeatherData(
    val city: String,
    val temperature: Double,
    val description: String,
    val humidity: Int,
    val wind_speed: Int,
    val weather_descriptions: List<String>,
    // Add other necessary fields
)