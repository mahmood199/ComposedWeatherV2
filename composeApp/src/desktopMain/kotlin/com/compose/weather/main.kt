package com.compose.weather

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ComposedWeatherV2",
    ) {
        App()
    }
}