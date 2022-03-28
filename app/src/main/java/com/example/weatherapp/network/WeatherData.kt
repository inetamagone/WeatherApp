package com.example.weatherapp.network

import com.squareup.moshi.Json

data class WeatherData (
    @Json(name = "dt") val updated_last: Int,
    @Json(name = "description") val weather_description: String,
    @Json(name = "temp") val current_temp: Double,
    @Json(name = "temp_min") val temperature_min: Double,
    @Json(name = "temp_max") val temperature_max: Double,
    @Json(name = "speed") val wind_speed: Double,
    @Json(name = "humidity") val current_humidity: Int,
    @Json(name = "pressure") val current_pressure: Int,
    @Json(name = "visibility") val current_visibility: Int
)