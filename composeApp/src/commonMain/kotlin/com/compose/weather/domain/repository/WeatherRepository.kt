package com.compose.weather.domain.repository

import com.compose.weather.model.BaseResponse
import com.compose.weather.model.FirstResponse
import com.compose.weather.network.RemoteDataSource
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class WeatherRepository(
    private val remoteDataSource: RemoteDataSource,
) {

    suspend fun getWeatherInfo(): Result<BaseResponse<FirstResponse>> {
        return runCatching {
            remoteDataSource.getData()
        }
    }

}