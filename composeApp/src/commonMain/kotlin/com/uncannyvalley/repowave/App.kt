package com.uncannyvalley.repowave

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.uncannyvalley.repowave.presentation.navigation.AppNavHost
import com.uncannyvalley.repowave.presentation.theme.RepoWaveTheme

@Composable
@Preview
fun App() {
    RepoWaveTheme {
        AppNavHost()
    }
}