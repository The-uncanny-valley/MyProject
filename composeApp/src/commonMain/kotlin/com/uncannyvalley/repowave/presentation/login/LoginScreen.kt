package com.uncannyvalley.repowave.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uncannyvalley.repowave.presentation.components.PasswordField
import com.uncannyvalley.repowave.presentation.components.PrimaryButton
import com.uncannyvalley.repowave.presentation.components.UsernameField
import myproject.composeapp.generated.resources.Res
import myproject.composeapp.generated.resources.login_btn
import myproject.composeapp.generated.resources.login_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    onLoginSuccess: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is LoginUiEvent.LoginSuccessEvent -> onLoginSuccess()
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(padding)
                    .imePadding()
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp)
                    .widthIn(max = 400.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(0.3f))

                Text(
                    text = stringResource(Res.string.login_title),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(32.dp))

                UsernameField(
                    value = state.username,
                    onValueChange = viewModel::onUsernameChanged
                )

                Spacer(modifier = Modifier.height(20.dp))

                PasswordField(
                    value = state.password,
                    onValueChange = viewModel::onPasswordChanged
                )

                Spacer(modifier = Modifier.height(20.dp))

                Spacer(modifier = Modifier.weight(0.7f))  // pushes button down

                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.login_btn),
                    isEnabled = state.isLoginButtonActive,
                    onClick = viewModel::onLoginClicked
                )

                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}
