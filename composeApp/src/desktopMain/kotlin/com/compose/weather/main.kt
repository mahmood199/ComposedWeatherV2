package com.compose.weather

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.compose.weather.ui.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ComposedWeatherV2",
    ) {
        App()
    }
}