package com.just.suntime.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.just.suntime.models.SunInfo
import io.reactivex.subjects.BehaviorSubject
import java.util.*

class MainViewModel : ViewModel() {
    private val sunInfoSubject: BehaviorSubject<SunInfo> = BehaviorSubject.create()
    private val sunInfoMutableLiveData: MutableLiveData<SunInfo> = MutableLiveData()

    //region Init
    init {
        sunInfoMutableLiveData.value = SunInfo(Date(0),
                Date(3600 * 1000),
                3600 * 1000)
    }
    //endregion

    //region Inputs

    //endregion

    //region Outputs
    fun getSunData(): MutableLiveData<SunInfo> {
        return sunInfoMutableLiveData
    }
    //endregion

}