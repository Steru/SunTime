package com.just.suntime.models.retrofit

import com.squareup.moshi.Json

class SunriseSunsetResponse(val results: SunriseData)

class SunriseData(val sunrise: String,
                  val sunset: String,
                  @Json(name = "day_length") val dayLength: Int)