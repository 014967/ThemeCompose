package com.example.themecompose.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color
import com.example.themecompose.ThemeColor

// design system colors
val Red1 = Color(0xFFFF0000)
val Red2 = Color(0xFFFF06A4)
val Red3 = Color(0xFFB80F0F)
val Red4 = Color(0xFFFF3B3B)
val Blue1 = Color(0xFF3F51B5)
val Blue2 = Color(0xFF2196F3)
val Blue3 = Color(0xFF03A9F4)
val Blue4 = Color(0xFF00BCD4)
val Yellow1 = Color(0xFFFFEB3B)
val Yellow2 = Color(0xFFFFC107)
val Yellow3 = Color(0xFFFF9800)
val Yellow4 = Color(0xFFFFF495)
val Green1 = Color(0xFF4CAF50)
val Green2 = Color(0xFF8BC34A)
val Green3 = Color(0xFFC8EBCA)
val Green4 = Color(0xFF07A293)

@Stable
class ColorScheme(
    primary: Color,
    secondary: Color,
    tertiary: Color,
    surface: Color,
) {
    var primary by mutableStateOf(primary, structuralEqualityPolicy())
        internal set
    var secondary by mutableStateOf(secondary, structuralEqualityPolicy())
        internal set
    var tertiary by mutableStateOf(tertiary, structuralEqualityPolicy())
        internal set
    var surface by mutableStateOf(surface, structuralEqualityPolicy())
        internal set

    fun copy(
        primary: Color = this.primary,
        secondary: Color = this.secondary,
        tertiary: Color = this.tertiary,
        surface: Color = this.surface,
    ): ColorScheme = ColorScheme(
        primary = primary,
        secondary = secondary,
        tertiary = tertiary,
        surface = surface,
    )
}

fun redColorScheme(
    primary: Color = Red1,
    secondary: Color = Red2,
    tertiary: Color = Red3,
    surface: Color = Red4,
): ColorScheme = ColorScheme(
    primary = primary,
    secondary = secondary,
    tertiary = tertiary,
    surface = surface,
)

fun blueColorScheme(
    primary: Color = Blue1,
    secondary: Color = Blue2,
    tertiary: Color = Blue3,
    surface: Color = Blue4,
): ColorScheme = ColorScheme(
    primary = primary,
    secondary = secondary,
    tertiary = tertiary,
    surface = surface,
)

fun yellowColorScheme(
    primary: Color = Yellow1,
    secondary: Color = Yellow2,
    tertiary: Color = Yellow3,
    surface: Color = Yellow4,
): ColorScheme = ColorScheme(
    primary = primary,
    secondary = secondary,
    tertiary = tertiary,
    surface = surface,
)
fun greenColorScheme(
    primary: Color = Green1,
    secondary: Color = Green2,
    tertiary: Color = Green3,
    surface: Color = Green4,
): ColorScheme = ColorScheme(
    primary = primary,
    secondary = secondary,
    tertiary = tertiary,
    surface = surface,
)

val LocalCustomColor = staticCompositionLocalOf {
    redColorScheme()
}

fun getCustomColor(currentTheme: ThemeColor): ColorScheme {
    return when (currentTheme) {
        ThemeColor.RED -> {
            redColorScheme()
        }

        ThemeColor.GREEEN -> {
            greenColorScheme()
        }

        ThemeColor.YELLOW -> {
            yellowColorScheme()
        }

        ThemeColor.BLUE -> {
            blueColorScheme()
        }
    }
}

internal fun ColorScheme.updateColorsFrom(other: ColorScheme) {
    primary = other.primary
    secondary = other.secondary
    tertiary = other.tertiary
    surface = other.surface
}
