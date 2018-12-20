package com.just.suntime.models

class SunriseQueryResponse(val results: SunriseDataResponse)

class SunriseDataResponse(val sunrise: String,
                          val sunset: String,
                          val dayLength: Int)

// coś z tym nazewnictwem jest nie halo...
