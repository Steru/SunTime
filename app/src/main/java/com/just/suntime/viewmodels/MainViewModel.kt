package com.just.suntime.viewmodels

import android.arch.lifecycle.ViewModel
import com.just.suntime.models.SunInfo
import java.util.*

class MainViewModel : ViewModel() {

    fun getSunData() : SunInfo {
        return SunInfo(Date(0), Date(3600 * 1000), 3600 * 1000)
    }
}