package com.kalashnyk.denys.sweather.repository.model

data class WeatherData(
    val date: String? = null,
    var list: List<WeatherForDay>? = null
)