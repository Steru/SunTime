package com.just.suntime.models.retrofit

import com.just.suntime.models.SunriseQueryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SunriseApi {
    @GET("/json")
    fun getSunTimes(@Query("lat") latitude : Double,
                    @Query("lng") longitude : Double,
                    @Query("formatted") formatted : Int = 0)
    : Call<SunriseQueryResponse>
}