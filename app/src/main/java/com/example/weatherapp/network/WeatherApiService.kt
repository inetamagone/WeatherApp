package com.example.weatherapp.network

import com.example.weatherapp.network.data.Main
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val API_Key = "91db09ff13832921fd93739ff0fcc890"
const val CITY = "Riga"
const val BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API_Key"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * A public interface that exposes the [getData] method
 */
interface WeatherApiService {
    /**
     * Returns a [List] of [Main] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "weather" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("weather")
    suspend fun getData(): List<Main>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object WeatherApi {
    val retrofitService: WeatherApiService by lazy { retrofit.create(WeatherApiService::class.java) }
}