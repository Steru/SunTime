package com.just.suntime.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

/**
 * Display the length of daylight with the correct format
 * @param dayLength the length of daylight which one will be formatted
 */
@BindingAdapter("showDayLength")
fun TextView.showDayLength(dayLength: Int) {
    text = SimpleDateFormat("HH:mm", Locale.getDefault()).format(dayLength)
}

