package com.uncannyvalley.repowave.presentation.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uncannyvalley.repowave.presentation.components.PrimaryButton
import myproject.composeapp.generated.resources.Res
import myproject.composeapp.generated.resources.onboarding_get_started_btn
import org.jetbrains.compose.resources.stringResource

@Composable
fun LandscapeLayout(
    onGetStartedClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {

        ImageSection(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextSection()

            Spacer(Modifier.height(28.dp))

            PrimaryButton(
                isEnabled = true,
                text = stringResource(Res.string.onboarding_get_started_btn),
                onClick = onGetStartedClick
            )
        }
    }
}
