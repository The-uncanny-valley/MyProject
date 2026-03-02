package com.uncannyvalley.repowave.presentation.onboarding

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uncannyvalley.repowave.presentation.theme.RepoWaveTheme

@Composable
fun OnboardingScreen(
    onGetStartedClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
        ) {

            val isWideScreen = maxWidth > 600.dp

            if (isWideScreen) {
                LandscapeLayout(onGetStartedClick)
            } else {
                PortraitLayout(onGetStartedClick)
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingScreen_Preview() {
    RepoWaveTheme(darkTheme = true) {
        OnboardingScreen(onGetStartedClick = {})
    }
}