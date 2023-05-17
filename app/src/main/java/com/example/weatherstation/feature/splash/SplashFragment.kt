package com.example.weatherstation.feature.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherstation.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("fragmentsplash", "hello")
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainScreenFragment())
        }, SPLASH_NAV_DELAY)
    }

    companion object {
        const val SPLASH_NAV_DELAY = 1500L
    }
}