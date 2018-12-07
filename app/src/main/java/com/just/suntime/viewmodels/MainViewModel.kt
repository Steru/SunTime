package com.just.suntime.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.just.suntime.models.SunInfo
import io.reactivex.subjects.BehaviorSubject
import java.util.*

class MainViewModel : ViewModel() {
    private val sunInfoSubject: BehaviorSubject<SunInfo> = BehaviorSubject.create()
    private val sunInfoMutableLiveData: MutableLiveData<SunInfo> = MutableLiveData()

    init {
        sunInfoMutableLiveData.setValue(SunInfo(Date(0),
                Date(3600 * 1000),
                3600 * 1000)
        )
    }

    fun getSunData(): MutableLiveData<SunInfo> {
        return sunInfoMutableLiveData
    }
}