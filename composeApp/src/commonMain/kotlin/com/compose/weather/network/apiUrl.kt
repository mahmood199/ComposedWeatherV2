package com.compose.weather.network

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.path
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Use this method for configuring the request url
 */
fun HttpRequestBuilder.apiUrl(path: String) {
    url {
        path(path)
    }
}

fun Map<String, Any?>.mapToJson() = Json.encodeToString(this)

fun Map<String, Any?>.mapToString(): Map<String, String> = this.mapValues { entry ->
    entry.value.toString() ?: ""
}