package com.example.WeatherDashboard

import org.springframework.stereotype.Service

@Service
class FavoriteCityService(private val favoriteCityRepository: FavoriteCityRepository) {

    fun saveFavoriteCity(cityName: String) {
        val favoriteCity = FavoriteCity(cityName = cityName)
        favoriteCityRepository.save(favoriteCity)
    }

    fun getFavoriteCities(): List<FavoriteCity> {
        return favoriteCityRepository.findAll()
    }
}
