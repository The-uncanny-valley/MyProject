package com.uncannyvalley.coursengine

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.uncannyvalley.coursengine.core.navigation.AppNavHost
import com.uncannyvalley.coursengine.core.presentation.theme.CourseEngineTheme

@Composable
@Preview
fun App() {
    CourseEngineTheme {
        AppNavHost()
    }
}