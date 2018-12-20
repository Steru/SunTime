package com.just.suntime.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.just.suntime.models.SunInfo
import io.reactivex.subjects.BehaviorSubject
import java.util.*

class MainViewModel : ViewModel() {
    private val sunInfoSubject: BehaviorSubject<SunInfo> = BehaviorSubject.create()
    private val sunInfoMutableLiveData: MutableLiveData<SunInfo> = MutableLiveData()

    init {

        // tutaj bedzie brana wartosc z serwera
        // 51.10, 17.03

        sunInfoMutableLiveData.value = SunInfo(Date(0),
                Date(3600 * 1000),
                3600 * 1000)
    }

    // Outputs
    fun getSunData(): MutableLiveData<SunInfo> {
        return sunInfoMutableLiveData
    }

}