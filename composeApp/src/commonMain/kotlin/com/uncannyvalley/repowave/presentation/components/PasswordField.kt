package com.uncannyvalley.repowave.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import myproject.composeapp.generated.resources.Res
import myproject.composeapp.generated.resources.ic_visibility_off
import myproject.composeapp.generated.resources.ic_visibility_on
import myproject.composeapp.generated.resources.login_hide_password_btn
import myproject.composeapp.generated.resources.login_password_placeholder
import myproject.composeapp.generated.resources.login_show_password_btn
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(stringResource(Res.string.login_password_placeholder)) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),

        visualTransformation = if (passwordVisible) VisualTransformation.None
        else PasswordVisualTransformation(),

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            autoCorrectEnabled = false
        ),
        singleLine = true,

        trailingIcon = {
            IconButton(
                onClick = { passwordVisible = !passwordVisible },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Icon(
                    painter = painterResource(
                        if (passwordVisible) Res.drawable.ic_visibility_on
                        else Res.drawable.ic_visibility_off
                    ),
                    contentDescription = if (passwordVisible)
                        stringResource(Res.string.login_hide_password_btn)
                    else stringResource(Res.string.login_show_password_btn),
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    )
}