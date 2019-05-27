package com.kalashnyk.denys.sweather.repository.server

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/data/2.5/forecast")
    fun getForecastByCityName(@Query("appid") apiKey: String, @Query("q") query: String) : Single<Response<ResponseBody>>

}
