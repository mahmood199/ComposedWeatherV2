package com.compose.weather.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class BaseResponse<T>(
    @SerialName("status")
    val status: Boolean,
    @SerialName("status_code")
    val statusCode: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: T
)