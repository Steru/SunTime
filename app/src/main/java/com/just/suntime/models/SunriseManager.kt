package com.just.suntime.models

import android.util.Log
import com.just.suntime.utils.Coordinates
import com.just.suntime.models.retrofit.RestAPI
import io.reactivex.Observable
import java.text.SimpleDateFormat
import java.util.*

/**
 * Class used to handle rest api logic behind the calls
 */
class SunriseManager(private val api: RestAPI = RestAPI()) {

    private val fullDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ",
            Locale.getDefault())

    fun getSunInfo(coordinates: Coordinates): Observable<SunInfo> {
        return Observable.create { subscriber ->
            val response = api.getSunInfo(coordinates).execute()
            if (response.isSuccessful && response.body() != null) {
                // TODO catch null body exception
                // !! means we're embracing the NPE, if body is null, there will be an exception
                val data = response.body()!!.results

                subscriber.onNext(
                        SunInfo(convertToHours(data.sunrise),
                                convertToHours(data.sunset),
                                data.dayLength))
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    private fun convertToHours(date: String): String {
        val fullDate = fullDateFormat.parse(date)
        return SimpleDateFormat("HH:mm", Locale.getDefault()).format(fullDate)
    }

}