package com.just.suntime.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.just.suntime.R
import com.just.suntime.databinding.ActivityMainBinding
import com.just.suntime.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel: MainViewModel =
                ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.viewModel = viewModel
    }
}
