package com.just.suntime.models

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

    fun getSunInfo(coordinates: Coordinates): Observable<FormattedSunInfo> {
        return Observable.create { subscriber ->
            val response = api.getSunInfo(coordinates).execute()
            if (response.isSuccessful && response.body() != null) {
                // TODO catch null body exception
                // !! means we're embracing the NPE, if body is null, there will be an exception
                val data = response.body()!!.results

                subscriber.onNext(
                        FormattedSunInfo(formatFullDateToHours(data.sunrise),
                                formatFullDateToHours(data.sunset),
                                formatSecondsToHours(data.dayLength)))
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    private val hoursMinutesFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    private fun formatFullDateToHours(date: String): String {
        return hoursMinutesFormat.format(fullDateFormat.parse(date))
    }

    private fun formatSecondsToHours(seconds: Int) : String {
        return hoursMinutesFormat.format(SimpleDateFormat("ss", Locale.getDefault())
                .parse(seconds.toString()))
    }

}