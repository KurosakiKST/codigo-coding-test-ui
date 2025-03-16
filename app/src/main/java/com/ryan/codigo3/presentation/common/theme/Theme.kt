package com.ryan.codigo3.presentation.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Color definitions
val Red = Color(0xFFE94335)
val LightRed = Color(0xFFF5C1BB)
val Gray = Color(0xFF9E9E9E)
val LightGray = Color(0xFFF5F5F5)
val DarkGray = Color(0xFF616161)
val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)
val GoldYellow = Color(0xFFFFD700)

// Light theme colors
private val LightColors = lightColorScheme(
    primary = Red,
    secondary = LightRed,
    background = White,
    surface = White,
    onPrimary = White,
    onSecondary = Red,
    onBackground = Black,
    onSurface = Black,
)

// Dark theme colors
private val DarkColors = darkColorScheme(
    primary = Red,
    secondary = LightRed,
    background = Black,
    surface = DarkGray,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
)

@Composable
fun CodigoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}