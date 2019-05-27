package com.kalashnyk.denys.sweather.repository.model

data class WeatherForDay(
    val hourData: String? = null,
    val description: String? = null,
    val temperature: String? = null,
    val windSpeed: String? = null
)