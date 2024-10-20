package com.compose.weather.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen(
    viewModel: FirstViewModel,
    modifier: Modifier = Modifier
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.makeApiCall()
    }

//    val state = viewModel.state.collectAsStateWithLifecycle()

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize(),
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
        ) {

            Text(text = "Code harder", textAlign = TextAlign.Center)

//            Text(text = "${state.value}", textAlign = TextAlign.Center)

            Button(
                onClick = {
                    viewModel.makeApiCall()
                }
            ) {
                Text("Code harder")
            }

        }

    }

}
