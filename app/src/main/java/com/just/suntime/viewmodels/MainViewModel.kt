package com.just.suntime.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.just.suntime.models.FormattedSunInfo
import com.just.suntime.models.SunriseManager
import com.just.suntime.utils.Coordinates
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class MainViewModel : ViewModel() {
    private val formattedSunInfoMutableLiveData: MutableLiveData<FormattedSunInfo> = MutableLiveData()
    private val sunriseManager = SunriseManager()
    private val sunriseInfoDisposable : Disposable

    init {
         sunriseInfoDisposable = sunriseManager.getSunInfo(Coordinates(51.10, 17.03))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    formattedSunInfoMutableLiveData.setValue(it)
                    //setvisibility(visible)
                    //hide spinner
                }

        //TODO display spinner when data is not available, not some hardcoded values
        formattedSunInfoMutableLiveData.value = FormattedSunInfo("00:00",
                "99:99",
                "000")
        // create and run here empty constructor for sunInfo
        // setVisibility of data to none
        // show spinner
    }

    // Outputs
    fun getFormattedSunData(): MutableLiveData<FormattedSunInfo> {
        return formattedSunInfoMutableLiveData
    }

    override fun onCleared() {
        super.onCleared()
        sunriseInfoDisposable.dispose()
    }
}