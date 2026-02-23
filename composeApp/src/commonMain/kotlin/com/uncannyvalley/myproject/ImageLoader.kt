package com.uncannyvalley.myproject

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

expect class ImageLoader() {
    @Composable
    fun LoadImage(
        url: String,
        contentDescription: String,
        modifier: Modifier = Modifier
    )
}