package com.just.suntime.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

/**
 * Display the date with the correct format
 * @param date the date which one will be formatted
 */
@BindingAdapter("showDate")
fun TextView.showDate(date: Date) {
    text = SimpleDateFormat("HH:mm", Locale.getDefault()).format(date)
}

/**
 * Display the length of daylight with the correct format
 * @param dayLength the length of daylight which one will be formatted
 */
@BindingAdapter("showDayLength")
fun TextView.showDayLength(dayLength: Int) {
    text = SimpleDateFormat("HH:mm", Locale.getDefault()).format(dayLength)
}

