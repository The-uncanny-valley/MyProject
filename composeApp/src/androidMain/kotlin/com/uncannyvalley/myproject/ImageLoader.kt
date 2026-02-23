package com.uncannyvalley.myproject

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

actual class ImageLoader actual constructor() {
    @Composable
    actual fun LoadImage(
        url: String,
        contentDescription: String,
        modifier: Modifier
    ) {
        AsyncImage(
            model = url,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = ContentScale.Fit
        )
    }
}