package com.example.epokafcm.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

suspend fun HttpURLConnection.applyConfig(config: HttpRequestConfig): String = withContext(Dispatchers.IO) {
    requestMethod = config.method
    config.headers.forEach { (key, value) ->
        setRequestProperty(key, value)
    }
    config.body?.let {
        doOutput = true
        outputStream.write(it.toByteArray())
    }
    inputStream.bufferedReader().use { it.readText() }
}

suspend fun sendHttpRequest(config: HttpRequestConfig): String = withContext(Dispatchers.IO) {
    val url = URL(config.url)
    val connection = url.openConnection() as HttpURLConnection
    try {
        connection.applyConfig(config)
    } finally {
        connection.disconnect()
    }
}