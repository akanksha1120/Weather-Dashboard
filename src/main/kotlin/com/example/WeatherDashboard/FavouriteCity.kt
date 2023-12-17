package com.example.WeatherDashboard

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class FavoriteCity(
    @Id
    val id: String? = null,
    val cityName: String
)
