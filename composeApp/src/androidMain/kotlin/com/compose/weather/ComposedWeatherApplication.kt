package com.compose.weather

import android.app.Application
import com.compose.weather.network.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ComposedWeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ComposedWeatherApplication)
            modules(viewModelModule)
            modules(appModules)
        }
    }
}