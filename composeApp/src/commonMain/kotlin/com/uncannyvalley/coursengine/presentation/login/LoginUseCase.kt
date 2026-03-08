package com.uncannyvalley.coursengine.presentation.login

import com.uncannyvalley.coursengine.domain.LoginRepository

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