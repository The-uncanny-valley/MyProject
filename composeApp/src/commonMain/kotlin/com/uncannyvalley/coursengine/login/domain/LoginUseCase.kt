package com.uncannyvalley.coursengine.login.domain

import com.uncannyvalley.coursengine.login.domain.LoginRepository

class LoginUseCase(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(
        username: String,
        password: String
    ): Result<Unit> {
        return loginRepository.login(username, password)
    }
}