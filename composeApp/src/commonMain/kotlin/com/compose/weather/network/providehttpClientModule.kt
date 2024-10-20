package com.compose.weather.network

import com.compose.weather.domain.repository.WeatherRepository
import com.compose.weather.ui.FirstViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import org.koin.dsl.module

val provideHttpClientModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    json = Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                        serializersModule = mapSerializerModule
                    },
                    contentType = ContentType.Any
                )
            }

            install(DefaultRequest) {
                url("https://run.mocky.io/v3/")
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
    }
}

val provideApiServiceModule = module {
    single { ApiService(get()) }
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

val mapSerializerModule = SerializersModule {
    contextual<LinkedHashMap<String, String>>(LinkedHashMapSerializer)
}