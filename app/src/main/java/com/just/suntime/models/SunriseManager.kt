package com.just.suntime.models

import android.util.Log
import com.just.suntime.utils.Coordinates
import com.just.suntime.models.retrofit.RestAPI
import io.reactivex.Observable
import java.util.*

/**
 * Class used to handle rest api logic behind the calls
 */
class SunriseManager(private val api: RestAPI = RestAPI()) {

    fun getSunInfo(coordinates: Coordinates): Observable<SunInfo> {
        return Observable.create { subscriber ->
            val response = api.getSunInfo(coordinates).execute()
            if (response.isSuccessful && response.body() != null) {
                // TODO catch null body exception
                // !! means we're embracing the NPE, if body is null, there will be an exception
                val data = response.body()!!.results

                //TODO get date from data strings
                Log.d("STRLOG", "rise: ${data.sunrise}, set: ${data.sunset}")
                subscriber.onNext(SunInfo(Date(10), Date(10), data.dayLength))
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

}