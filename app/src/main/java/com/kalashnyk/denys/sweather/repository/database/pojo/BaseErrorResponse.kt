package com.kalashnyk.denys.sweather.repository.database.pojo

import com.google.gson.annotations.SerializedName

data class BaseErrorResponse (
    @SerializedName("cod")
    val code: Int? = null,
    @SerializedName("message")
    override val message: String? = null
) : Throwable()