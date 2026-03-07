package com.uncannyvalley.coursengine

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform