package com.compose.weather.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
class BaseResponse<T>(
    @SerialName("status_code")
    val statusCode: Int,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val data: T
)