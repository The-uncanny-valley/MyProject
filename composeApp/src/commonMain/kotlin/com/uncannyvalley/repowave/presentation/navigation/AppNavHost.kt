package com.uncannyvalley.repowave.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uncannyvalley.repowave.presentation.login.LoginScreen
import com.uncannyvalley.repowave.presentation.onboarding.OnboardingScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Onboarding,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        composable<Onboarding> {
            OnboardingScreen(
                onGetStartedClick = {
                    navController.navigate(Login)
                }
            )
        }

        composable<Login> {
            LoginScreen()
        }
    }
}