package com.uncannyvalley.myproject

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.uncannyvalley.myproject.presentation.navigation.AppNavHost
import com.uncannyvalley.myproject.presentation.theme.MyAppTheme

@Composable
@Preview
fun App() {
    MyAppTheme {
        AppNavHost()
    }
}