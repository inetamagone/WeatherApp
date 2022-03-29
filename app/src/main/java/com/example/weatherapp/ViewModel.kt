package com.example.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.network.WeatherApi
import com.example.weatherapp.network.data.Main

enum class WeatherApiStatus { LOADING, ERROR, DONE }

/**
 * The [ViewModel] that is attached to what??
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<WeatherApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<WeatherApiStatus> = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of Main
    // with new values
    private val _photos = MutableLiveData<List<Main>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val photos: LiveData<List<Main>> = _photos

    /**
     * Call getWeatherData() on init so we can display status immediately.
     */
    init {
        getWeatherData()
    }

    /**
     * Gets weather data information from the Weather API Retrofit service and updates the
     * [Main] [List] [LiveData].
     */
    private fun getWeatherData() {

//        viewModelScope.launch {
//            _status.value = WeatherApiStatus.LOADING
//            try {
//                _photos.value = WeatherApi.retrofitService.getData()
//                _status.value = WeatherApiStatus.DONE
//            } catch (e: Exception) {
//                _status.value = WeatherApiStatus.ERROR
//                _photos.value = listOf()
//            }
//        }
    }
}