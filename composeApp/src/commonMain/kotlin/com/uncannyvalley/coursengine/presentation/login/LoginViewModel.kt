package com.uncannyvalley.coursengine.presentation.login

import androidx.lifecycle.viewModelScope
import com.uncannyvalley.coursengine.data.LoginRepositoryImpl
import com.uncannyvalley.coursengine.presentation.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase = LoginUseCase(LoginRepositoryImpl())
) : BaseViewModel<LoginUiState>(LoginUiState()) {

    private val _events = MutableSharedFlow<LoginUiEvent>()
    val events = _events.asSharedFlow()

    fun onLoginClicked() {
        viewModelScope.launch {

            val currentState = state.value

            val result = loginUseCase(
                currentState.username,
                currentState.password
            )

            result.fold(
                onSuccess = {
                    _events.emit(LoginUiEvent.LoginSuccessEvent)
                },
                onFailure = { exception ->
                    updateState {
                        copy(error = exception.message ?: "Login failed")
                    }
                }
            )
        }
    }

    fun onUsernameChanged(username: String) {
        updateState {
            copy(
                username = username,
                isLoginButtonActive = validate(username, password)
            )
        }
    }

    fun onPasswordChanged(password: String) {
        updateState {
            copy(
                password = password,
                isLoginButtonActive = validate(username, password)
            )
        }
    }
}

private fun validate(username: String, password: String): Boolean {
    return username.isNotBlank() && password.length >= 8
}