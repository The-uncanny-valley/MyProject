package com.uncannyvalley.coursengine.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uncannyvalley.coursengine.presentation.theme.CourseEngineTheme

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = false,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = isEnabled,
        modifier = modifier,
        shape = RoundedCornerShape(28.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContentColor = MaterialTheme.colorScheme.onBackground
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (isEnabled) MaterialTheme.colorScheme.outlineVariant
            else MaterialTheme.colorScheme.outline
        )
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 18.dp),
            text = text.uppercase(),
            style = MaterialTheme.typography.labelMedium
        )
    }
}


@Preview
@Composable
fun PrimaryButton_Preview() {
    CourseEngineTheme() {
        PrimaryButton(text = "Click me", onClick = {})
    }
}

@Preview
@Composable
fun PrimaryButton_Preview2() {
    CourseEngineTheme(darkTheme = true) {
        PrimaryButton(text = "Click me", isEnabled = true, onClick = {})
    }
}