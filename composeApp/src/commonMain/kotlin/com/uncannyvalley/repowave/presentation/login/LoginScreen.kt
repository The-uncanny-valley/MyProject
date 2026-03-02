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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uncannyvalley.repowave.presentation.components.EmailField
import com.uncannyvalley.repowave.presentation.components.PasswordField
import com.uncannyvalley.repowave.presentation.components.PrimaryButton
import myproject.composeapp.generated.resources.Res
import myproject.composeapp.generated.resources.login_btn
import myproject.composeapp.generated.resources.login_title
import myproject.composeapp.generated.resources.skip_btn
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreen() {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

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

                EmailField(
                    value = email,
                    onValueChange = { email = it }
                UsernameField(
                )

                Spacer(modifier = Modifier.height(20.dp))

                PasswordField(
                    value = password,
                    onValueChange = { password = it }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Spacer(modifier = Modifier.weight(0.7f))  // pushes button down

                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.login_btn),
                    onClick = {}
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(text = stringResource(Res.string.skip_btn))
            }
        }
    }
}
