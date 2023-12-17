package com.example.WeatherDashboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WeatherDashboardApplication

fun main(args: Array<String>) {
	runApplication<WeatherDashboardApplication>(*args)
}
