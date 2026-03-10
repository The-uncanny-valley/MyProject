package com.uncannyvalley.coursengine.login.domain

interface LoginRepository {
    suspend fun login(
        username: String,
        password: String
    ): Result<Unit>
}