package com.compose.weather.network

private suspend fun <T> safeInvoke(block: (suspend () -> T)): Result<T> {
    return kotlin.runCatching {
        block()
    }
}

private fun <T> Result<T>.log(): Result<T> {
    return onSuccess {
//            Log.e("API_SUCCESS::", "$it")
    }.onFailure {
        it.printStackTrace()
    }
}
