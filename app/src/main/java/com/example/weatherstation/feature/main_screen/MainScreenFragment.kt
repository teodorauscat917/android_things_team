package com.example.weatherstation.feature.main_screen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import com.example.weatherstation.R
import com.example.weatherstation.databinding.FragmentMainBinding
import com.example.weatherstation.viewmodel.WeatherViewModel
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class MainScreenFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)
    private val weatherViewModel: WeatherViewModel by activityViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        weatherViewModel.getData()
//        while (true) {
//            Handler(Looper.getMainLooper()).postDelayed({
//                weatherViewModel.getData()
//            }, MAIN_FRAGMENT_DELAY)
//        }
    }

    private fun initObservers() {
        weatherViewModel.receivedData.observe(viewLifecycleOwner) { receivedData ->
            binding.temperatureTV.text = receivedData.temperature
            binding.humidityTV.text = receivedData.humidity
        }
    }

    companion object {
        const val MAIN_FRAGMENT_DELAY = 1500L
    }
}