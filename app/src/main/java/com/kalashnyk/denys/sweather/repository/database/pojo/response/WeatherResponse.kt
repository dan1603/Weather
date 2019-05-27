package com.kalashnyk.denys.sweather.repository.database.pojo.response

import com.google.gson.annotations.SerializedName

class WeatherResponse (
    @SerializedName("main")
    val main: String? = null,
    @SerializedName("description")
    val description: String? = null
)