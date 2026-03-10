package com.uncannyvalley.coursengine.core.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Yellow,
    onPrimary = Onyx,
    secondary = Cyan,
    onSecondary = Onyx,
    background = Onyx,
    onBackground = White,
    outline = White,
    outlineVariant = Onyx,
    onSurface = LightGrey
)

private val LightColorScheme = lightColorScheme(
    primary = ElectricLime,
    onPrimary = Onyx,
    secondary = Mint,
    onSecondary = Onyx,
    background = WhiteChalk,
    onBackground = Onyx,
    outline = Onyx,
    outlineVariant = Onyx,
    onSurface = BlackOlive
)

@Composable
fun CourseEngineTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography(),
        content = content
    )
}