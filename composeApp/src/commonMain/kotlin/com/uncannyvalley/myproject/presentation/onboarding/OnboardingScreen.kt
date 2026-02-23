package com.uncannyvalley.myproject.presentation.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uncannyvalley.myproject.ImageLoader
import com.uncannyvalley.myproject.presentation.components.PrimaryButton
import com.uncannyvalley.myproject.presentation.theme.MyAppTheme

@Composable
fun OnboardingScreen(
    onGetStartedClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
                .padding(20.dp)
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val imageLoader = ImageLoader()

            imageLoader.LoadImage(
                url = "https://raw.githubusercontent.com/The-uncanny-valley/Images/main/meme.jpeg",
                contentDescription = "Onboarding meme",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Welcome to my app!",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Just because you're trash doesn't mean you can't do great things. It's called garbage can, not garbage cannot.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth().padding(24.dp)
            )

            Spacer(modifier = Modifier.height(16.dp)) // gap before button

            PrimaryButton(
                isEnabled = true,
                text = "Get started",
                onClick = onGetStartedClick
            )
        }
    }
}

@Preview
@Composable
fun OnBoardingScreen_Preview() {
    MyAppTheme(darkTheme = true) {
        OnboardingScreen(onGetStartedClick = {})
    }
}