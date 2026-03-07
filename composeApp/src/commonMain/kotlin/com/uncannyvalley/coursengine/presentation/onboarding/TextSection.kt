package com.uncannyvalley.coursengine.presentation.onboarding

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import courseengine.composeapp.generated.resources.Res
import courseengine.composeapp.generated.resources.onboarding_text
import courseengine.composeapp.generated.resources.onboarding_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun TextSection() {
    Text(
        text = stringResource(Res.string.onboarding_title),
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onBackground,
        textAlign = TextAlign.Center
    )

    Spacer(modifier = Modifier.height(28.dp))

    Text(
        text = stringResource(Res.string.onboarding_text),
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurface,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(horizontal = 24.dp)
    )
}