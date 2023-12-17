package com.example.WeatherDashboard

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Controller
class WeatherController(private val weatherService: WeatherService) {

    @GetMapping("/")
    fun home(): String {
        return "index"
    }

    @GetMapping("/weather")
    fun getWeather(@RequestParam city: String): ResponseEntity<WeatherData> {
        val weatherData = weatherService.getWeatherData(city)
        return ResponseEntity.ok(weatherData)
    }

    @GetMapping("/forecast")
    fun getWeatherForecast(@RequestParam city: String): ResponseEntity<WeatherForecastData> {
        val weatherForecastData = weatherService.getWeatherForecast(city)
        return ResponseEntity.ok(weatherForecastData)
    }


}
