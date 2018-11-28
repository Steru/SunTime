package com.just.suntime

import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun getSunData() : SunInfo {
        return SunInfo("6:00", "18:00", "12:00")
    }
}