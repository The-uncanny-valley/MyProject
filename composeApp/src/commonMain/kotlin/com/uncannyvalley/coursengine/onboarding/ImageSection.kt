package com.uncannyvalley.coursengine.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import courseengine.composeapp.generated.resources.Res
import courseengine.composeapp.generated.resources.placeholder
import org.jetbrains.compose.resources.painterResource

@Composable
fun ImageSection(modifier: Modifier = Modifier) {

    AsyncImage(
        model = "https://raw.githubusercontent.com/The-uncanny-valley/Images/main/meme.jpeg",
        contentDescription = "Onboarding meme",
        modifier = modifier,
        contentScale = ContentScale.Fit,

        placeholder = painterResource(Res.drawable.placeholder),
        error = painterResource(Res.drawable.placeholder)
    )
}