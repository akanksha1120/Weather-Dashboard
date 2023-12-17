package com.example.WeatherDashboard

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Service
class WeatherService(private val restTemplate: RestTemplate) {

    fun getWeatherData(city: String): WeatherData {
        val apiKey = "OUR_API_KEY" // Replace this placeholder with your actual API key
        val baseUrl = "http://api.weatherstack.com/current"
        val uri = UriComponentsBuilder.fromUriString(baseUrl)
            .queryParam("access_key", apiKey)
            .queryParam("query", city)
            .build()
            .toUriString()

        val response = restTemplate.getForObject(uri, WeatherStackResponse::class.java)
            ?: throw RuntimeException("Failed to fetch weather data")

        // Map the response to your WeatherData model
        return WeatherData(
            city = response.location.name,
            temperature = response.current.temperature,
            description = response.location.region,
            humidity = response.current.humidity,
            wind_speed = response.current.wind_speed,
            weather_descriptions = response.current.weather_descriptions,
            // Add other necessary fields from the response
        )
    }

    fun getWeatherForecast(city: String): WeatherForecastData {
        val apiKey = "YOUR_API_KEY" // Replace this placeholder with your actual API key
        val baseUrl = "https://api.weatherbit.io/v2.0/forecast/daily"
        val uri = UriComponentsBuilder.fromUriString(baseUrl)
            .queryParam("key", apiKey)
            .queryParam("city", city)
            .build()
            .toUriString()

        val response = restTemplate.getForObject(uri, WeatherForecastStackResponse::class.java)
            ?: throw RuntimeException("Failed to fetch weather data")

        // Map the response to your WeatherForecastData model
        return WeatherForecastData(
            city_name = response.city_name,
            forecast = response.data.take(5).map {
                ForecastTemperature(
                    date = it.valid_date,
                    temperature = it.temp
                    // Add more details as needed
                )
            },
            country_code = response.country_code,
            state_code = response.state_code
            // Add other necessary fields from the WeatherForecastStackResponse
        )
    }
}
