package com.kalashnyk.denys.sweather.repository.database.pojo.response

import com.google.gson.annotations.SerializedName

class MainResponse (
    @SerializedName("temp")
    val temp: String? = null
)