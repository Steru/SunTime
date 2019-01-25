package com.just.suntime.models.retrofit

import com.just.suntime.utils.Coordinates
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RestAPI {

    private val sunriseApi: SunriseSunsetApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.sunrise-sunset.org")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        sunriseApi = retrofit.create(SunriseSunsetApi::class.java)
    }

    fun getSunInfo(coordinates: Coordinates): Call<SunriseSunsetResponse> {
        return sunriseApi.getSunTimes(coordinates.latitude, coordinates.longitude)
    }
}