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

    private val _state = MutableStateFlow(false)
    val state = _state.asStateFlow()

    fun makeApiCall() {
        viewModelScope.launch {
            val result = repository.getWeatherInfo()
            result.onSuccess {

            }.onFailure {

            }
        }
    }

}