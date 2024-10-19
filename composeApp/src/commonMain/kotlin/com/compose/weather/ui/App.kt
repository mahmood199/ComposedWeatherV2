package com.compose.weather.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.compose.weather.network.appModule
import org.koin.compose.KoinApplication

@Composable
fun App() {
    MaterialTheme {
        KoinApplication(
            application = {
                modules(appModule())
            }
        ) {
            FirstScreen()
        }
    }
}