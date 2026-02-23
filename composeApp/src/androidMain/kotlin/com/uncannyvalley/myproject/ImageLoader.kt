package com.uncannyvalley.myproject

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter
import myproject.composeapp.generated.resources.Res
import myproject.composeapp.generated.resources.loading
import myproject.composeapp.generated.resources.placeholder
import org.jetbrains.compose.resources.painterResource

actual class ImageLoader actual constructor() {
    @Composable
    actual fun LoadImage(
        url: String,
        contentDescription: String,
        modifier: Modifier
    ) {
        val painter = rememberAsyncImagePainter(
            model = url,
            placeholder = painterResource(Res.drawable.loading),
            error = painterResource(Res.drawable.placeholder)
        )

        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = ContentScale.Fit
        )
    }
}