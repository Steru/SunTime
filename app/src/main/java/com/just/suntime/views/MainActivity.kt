package com.just.suntime.views

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.content.pm.PackageManager
import android.databinding.DataBindingUtil
import android.location.Location
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.just.suntime.viewmodels.MainViewModel
import com.just.suntime.R
import com.just.suntime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val LOCATION_REQUEST_CODE = 11111

    private lateinit var fusedLocation: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel: MainViewModel =
                ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.viewModel = viewModel

        fusedLocation = LocationServices.getFusedLocationProviderClient(this)

        checkPermissionForLocation()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            LOCATION_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    requestForLocation()
                } else {
                    finish()
                }
                return
            }
        }
    }

    private fun checkPermissionForLocation() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        arrayOf(android.Manifest.permission.READ_CONTACTS),
                        LOCATION_REQUEST_CODE)
            }
        } else {
            requestForLocation()
        }
    }

    @SuppressLint("MissingPermission")
    private fun requestForLocation() {
        fusedLocation.lastLocation.addOnSuccessListener { location: Location? ->
            location?.let {
                // TODO handle the location
            }
        }
    }


}
