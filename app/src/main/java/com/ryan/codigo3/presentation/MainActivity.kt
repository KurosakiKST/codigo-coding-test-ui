package com.ryan.codigo3.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ryan.codigo3.presentation.common.theme.CodigoTheme
import com.ryan.codigo3.presentation.hotelDetails.HotelDetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodigoTheme {
                CodigoApp()
            }
        }
    }
}

@Composable
fun CodigoApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "hotel_detail"
    ) {
        composable(
            route = "hotel_detail",
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(300)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(300)
                )
            }
        ) {
            HotelDetailScreen()
        }
    }
}