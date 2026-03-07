package com.uncannyvalley.coursengine.domain

interface LoginRepository {
    suspend fun login(
        username: String,
        password: String
    ): Result<Unit>
}