package com.compose.weather

import com.compose.weather.ui.FirstViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { FirstViewModel(get()) }
}
