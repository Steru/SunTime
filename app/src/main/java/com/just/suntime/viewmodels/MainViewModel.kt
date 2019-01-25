package com.just.suntime.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.just.suntime.models.FormattedSunInfo
import com.just.suntime.models.SunriseManager
import com.just.suntime.utils.Coordinates
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    val formattedSunInfo: MutableLiveData<FormattedSunInfo> = MutableLiveData()
    val isSunDataAvailable : MutableLiveData<Boolean> = MutableLiveData()

    private val sunriseManager = SunriseManager()
    private val sunriseInfoDisposable : Disposable

    init {
         sunriseInfoDisposable = sunriseManager.getSunInfo(Coordinates(51.10, 17.03))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    formattedSunInfo.value = it
                    isSunDataAvailable.value = true
                }

        formattedSunInfo.value = FormattedSunInfo()
        isSunDataAvailable.value = false
    }

    override fun onCleared() {
        super.onCleared()
        sunriseInfoDisposable.dispose()
    }
}