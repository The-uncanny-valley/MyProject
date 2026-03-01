package com.uncannyvalley.repowave

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform