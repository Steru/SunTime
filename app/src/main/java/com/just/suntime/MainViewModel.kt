package com.just.suntime

import android.arch.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {

    fun getSunData() : SunInfo {
        return SunInfo(Date(0), Date(3600 * 1000), 3600*1000)
    }
}