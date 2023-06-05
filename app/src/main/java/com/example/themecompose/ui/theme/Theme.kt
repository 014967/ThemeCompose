package com.example.themecompose.ui.theme

import androidx.compose.runtime.Composable
import com.example.themecompose.ThemeColor

@Composable
fun ThemeComposeTheme(currentTheme: ThemeColor, content: @Composable () -> Unit) {
    val colors = getCustomColor(currentTheme)

    CustomTheme(
        colors = colors,
        typography = ThemeComposeTheme.typography,
        content = content,
    )
}

object ThemeComposeTheme {
    val color: ColorScheme
        @Composable
        get() = LocalCustomColor.current

    val typography: OmyudaTypography
        @Composable
        get() = LocalCustomTypography.current
}
