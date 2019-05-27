package com.kalashnyk.denys.sweather.repository.database.pojo.response

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("cod")
    val code: Int? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("cnt")
    val count: Int? = null,
    @SerializedName("list")
    val list: List<ForecastResponse>? = null,
    @SerializedName("city")
    val city: CityResponse? = null
)