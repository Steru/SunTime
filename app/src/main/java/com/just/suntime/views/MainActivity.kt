package com.just.suntime.views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.just.suntime.R
import com.just.suntime.databinding.ActivityMainBinding
import com.just.suntime.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel: MainViewModel =
                ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.isSunDataAvailable.observe(this, Observer {
            sun_data_group.visibility = if (it) View.VISIBLE else View.INVISIBLE
            //TODO display spinner when data is not available
        })

    }
}
