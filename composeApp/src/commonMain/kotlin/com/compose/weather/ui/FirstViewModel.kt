package com.compose.weather.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FirstViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

//    private val _state = MutableStateFlow<String?>(null)
//    val state = _state.asStateFlow()

    fun makeApiCall() {
        viewModelScope.launch {
            val result = repository.getWeatherInfo()
//            result.onSuccess {
//                _state.value = "${it.status}\n${it.statusCode}\n${it.message}\n${it.data}"
//            }.onFailure {
//                it.printStackTrace()
//            }
        }
    }

}