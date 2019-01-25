package com.just.suntime.models.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SunriseSunsetApi {
    @GET("/json")
    fun getSunTimes(@Query("lat") latitude : Double,
                    @Query("lng") longitude : Double,
                    @Query("formatted") formatted : Int = 0)
    : Call<SunriseSunsetResponse>
}