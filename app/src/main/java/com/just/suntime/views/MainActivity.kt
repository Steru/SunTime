package com.just.suntime.views

import android.os.Bundle
import android.transition.TransitionManager
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.just.suntime.R
import com.just.suntime.databinding.ActivityMainBinding
import com.just.suntime.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dataConstraintSet: ConstraintSet = ConstraintSet()
    private val spinnerConstraintSet: ConstraintSet = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel: MainViewModel =
                ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)

        viewModel.isSunDataAvailable.observe(this, Observer { dataAvailable ->
            TransitionManager.beginDelayedTransition(data_container)
            if(dataAvailable) {
                dataConstraintSet.applyTo(data_container)
            } else {
                spinnerConstraintSet.applyTo(data_container)
            }
        })

        dataConstraintSet.clone(data_container)

        spinnerConstraintSet.clone(this, R.layout.sun_data_views)
        spinnerConstraintSet.applyTo(data_container)
    }
}
