package com.just.suntime.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.just.suntime.models.SunInfo
import com.just.suntime.models.SunriseManager
import com.just.suntime.utils.Coordinates
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import java.util.*

class MainViewModel : ViewModel() {
    private val sunInfoSubject: BehaviorSubject<SunInfo> = BehaviorSubject.create()
    private val sunInfoMutableLiveData: MutableLiveData<SunInfo> = MutableLiveData()
    private val sunriseManager = SunriseManager()
    private val sunriseInfoDisposable : Disposable

    init {
         sunriseInfoDisposable = sunriseManager.getSunInfo(Coordinates(51.10, 17.03))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    sunInfoMutableLiveData.setValue(it)
                }

        //TODO display spinner when data is not available, not some hardcoded values
        sunInfoMutableLiveData.value = SunInfo(Date(0),
                Date(3600 * 1000),
                3600 * 1000)
    }

    // Outputs
    fun getSunData(): MutableLiveData<SunInfo> {
        return sunInfoMutableLiveData
    }

    override fun onCleared() {
        super.onCleared()
        sunriseInfoDisposable.dispose()
    }
}