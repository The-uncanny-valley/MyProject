package com.uncannyvalley.coursengine.data.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import io.github.aakira.napier.Napier
import io.ktor.client.plugins.logging.LogLevel

object NetworkClient {

    val httpClient = HttpClient {

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    prettyPrint = true
                }
            )
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.d(tag = "HTTP", message = message)
                }
            }

            level = LogLevel.ALL
        }
    }
}