package com.uncannyvalley.myproject

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text

actual class ImageLoader actual constructor() {
    @Composable
    actual fun LoadImage(
        url: String,
        contentDescription: String,
        modifier: Modifier
    ) {
        // a placeholder box with text
        Box(modifier = modifier) {
            Text("Image not supported on this platform")
        }
    }
}
