package com.compose.weather

import android.app.Application
import org.koin.core.context.startKoin

class ComposedWeatherApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {

        }
    }
}