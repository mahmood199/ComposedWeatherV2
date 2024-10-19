package com.compose.weather.domain.repository

import com.compose.weather.network.RemoteDataSource
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class WeatherRepository(
    val remoteDataSource: RemoteDataSource,
) {

    suspend fun getWeatherInfo(): Result<Int> {
        return runCatching {
            delay(2.seconds)
            1
        }
    }

}