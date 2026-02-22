package com.uncannyvalley.myproject.presentation.login

import androidx.compose.foundation.background
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
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uncannyvalley.myproject.presentation.components.EmailField
import com.uncannyvalley.myproject.presentation.components.PasswordField
import com.uncannyvalley.myproject.presentation.components.PrimaryButton
import com.uncannyvalley.myproject.presentation.theme.MyAppTheme

@Composable
fun LoginScreen() {
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
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
                    text = "Login",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(32.dp))

                EmailField(emailState)

                Spacer(modifier = Modifier.height(20.dp))

                PasswordField(passwordState)

                Spacer(modifier = Modifier.weight(0.7f))  // pushes button down

                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Login",
                    onClick = {}
                )

                Text(text = "Skip")

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreen_Preview() {
    MyAppTheme { LoginScreen() }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreen_Preview_Dark() {
    MyAppTheme(darkTheme = true) { LoginScreen() }
}

@Preview(
    showSystemUi = false,
    device = "spec:width=1280dp,height=800dp,dpi=240",
    showBackground = true
)
@Composable
fun LoginScreen_Preview_Tablet_Landscape() {
    MyAppTheme {
        LoginScreen()
    }
}