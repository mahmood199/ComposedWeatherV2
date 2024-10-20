package com.compose.weather.network

import com.compose.weather.model.BaseResponse
import com.compose.weather.model.FirstResponse
import io.ktor.client.call.body

class RemoteDataSource(
    private val apiService: ApiService
) {

    suspend fun getData(): BaseResponse<FirstResponse> {
        return apiService.getCommentById().body() as BaseResponse<FirstResponse>
    }

}