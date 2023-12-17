package com.example.WeatherDashboard

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/favorite-cities")
class FavoriteCityController(private val favoriteCityService: FavoriteCityService) {

    @PostMapping("/save")
    fun saveFavoriteCity(@RequestParam cityName: String): ResponseEntity<String> {
        favoriteCityService.saveFavoriteCity(cityName)
        return ResponseEntity.ok("Favorite city saved successfully")
    }

    @GetMapping("/list")
    fun getFavoriteCities(): List<FavoriteCity> {
        return favoriteCityService.getFavoriteCities()
    }
}
