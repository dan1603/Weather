package com.kalashnyk.denys.sweather.repository.database.pojo.response

import com.google.gson.annotations.SerializedName

data class WindResponse(
    @SerializedName("speed")
    val speed: String? = null,
    @SerializedName("deg")
    val deg: String? = null
)