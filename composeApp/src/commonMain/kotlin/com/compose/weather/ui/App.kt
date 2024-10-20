package com.compose.weather.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.KoinContext

@Composable
fun App(
    viewModel: FirstViewModel,
    modifier: Modifier = Modifier
) {
    MaterialTheme {
        KoinContext {
            FirstScreen(
                viewModel = viewModel,
                modifier = modifier.fillMaxSize()
            )
        }
    }
}