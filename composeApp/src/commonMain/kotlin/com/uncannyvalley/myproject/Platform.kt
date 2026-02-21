package com.uncannyvalley.myproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform