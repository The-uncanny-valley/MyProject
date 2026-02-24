package com.uncannyvalley.myproject.presentation.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uncannyvalley.myproject.ImageLoader

@Composable
fun ImageSection(modifier: Modifier) {
    val imageLoader = ImageLoader()

    imageLoader.LoadImage(
        url = "https://raw.githubusercontent.com/The-uncanny-valley/Images/main/meme.jpeg",
        contentDescription = "Onboarding meme",
        modifier = modifier
    )
}