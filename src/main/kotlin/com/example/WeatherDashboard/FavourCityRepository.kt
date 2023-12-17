package com.example.WeatherDashboard

import org.springframework.data.mongodb.repository.MongoRepository

interface FavoriteCityRepository : MongoRepository<FavoriteCity, String>
