package com.compose.weather.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ApiService(
    private val client: HttpClient
) {

    suspend fun getCommentById() = client.get {
        apiUrl("992252e7-aedf-4d1a-bb82-e4a569b3babb")
    }


}