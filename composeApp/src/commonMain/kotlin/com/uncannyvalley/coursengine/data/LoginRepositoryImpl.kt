package com.uncannyvalley.coursengine.data

import com.uncannyvalley.coursengine.domain.InvalidCredentialsException
import com.uncannyvalley.coursengine.domain.LoginRepository

class LoginRepositoryImpl : LoginRepository {

    override suspend fun login(
        username: String,
        password: String
    ): Result<Unit> {


        return if (isValid(username, password)) {
            Result.success(Unit)
        } else {
            Result.failure(InvalidCredentialsException())
        }
    }

    private fun isValid(username: String, password: String): Boolean {
        if (username.isBlank() || password.isBlank()) return false

        return username == "admin" && password == "12345678"
    }
}
