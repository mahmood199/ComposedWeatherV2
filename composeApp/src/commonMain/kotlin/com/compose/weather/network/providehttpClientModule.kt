package com.compose.weather.network

import com.compose.weather.domain.repository.WeatherRepository
import com.compose.weather.ui.FirstViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val provideHttpClientModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
        }
    }
}

val provideApiServiceModule = module {
    single { ApiService() }
}

val provideDataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSource(get()) }
}

val provideRepositoryModule = module {
    single<WeatherRepository> { WeatherRepository(get()) }
}

val viewModelModule = module {
    factory { FirstViewModel(get()) }
}


fun appModule() = listOf(
    provideHttpClientModule,
    provideApiServiceModule,
    provideDataSourceModule,
    provideRepositoryModule,
    viewModelModule
)