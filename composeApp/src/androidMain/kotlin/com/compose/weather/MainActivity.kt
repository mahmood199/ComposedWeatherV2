package com.compose.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.compose.weather.network.appModules
import com.compose.weather.network.initializeKoin
import com.compose.weather.ui.App
import com.compose.weather.ui.FirstViewModel
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel
import org.koin.dsl.koinApplication

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = koinViewModel<FirstViewModel>()
            App(viewModel = viewModel)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    KoinApplication(
        application = {
            modules(viewModelModule)
            modules(appModules)
        }
    ) {
        val viewModel = koinViewModel<FirstViewModel>()
        App(viewModel)
    }
}