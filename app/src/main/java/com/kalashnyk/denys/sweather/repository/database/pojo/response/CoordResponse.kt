package com.kalashnyk.denys.sweather.repository.database.pojo.response

import com.google.gson.annotations.SerializedName

data class CoordResponse(
    @SerializedName("lat")
    val lat: String? = null,
    @SerializedName("lon")
    val lon: String? = null
)