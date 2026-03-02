package com.uncannyvalley.repowave.presentation.login

data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val isLoginButtonActive: Boolean = false,
    val error: String? = null
)

sealed class LoginUiEvent {
    object LoginSuccessEvent : LoginUiEvent()
}