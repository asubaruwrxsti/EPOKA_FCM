package com.example.epokafcm.utils

data class HttpRequestConfig(
    val url: String,
    val method: String = "GET",
    val headers: Map<String, String> = emptyMap(),
    val body: String? = null
)