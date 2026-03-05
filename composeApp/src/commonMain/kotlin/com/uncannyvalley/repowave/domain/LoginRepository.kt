package com.uncannyvalley.repowave.domain

interface LoginRepository {
    suspend fun login(
        username: String,
        password: String
    ): Result<Unit>
}