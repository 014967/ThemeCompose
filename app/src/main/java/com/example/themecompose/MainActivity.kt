package com.example.themecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.themecompose.ui.theme.ThemeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var currentThemeColor by remember { mutableStateOf(ThemeColor.RED) }

            ThemeComposeTheme(
                currentTheme = currentThemeColor,
            ) {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting(changeTheme = {
                        currentThemeColor = it
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(
    changeTheme: (ThemeColor) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Row(
            modifier = Modifier.width(100.dp).clickable {
                changeTheme(ThemeColor.RED)
            }.background(color = ThemeComposeTheme.color.primary),

        ) {
            Text(style = ThemeComposeTheme.typography.bodyNormal14, text = "빨강 테마를 적용할꺼야")
        }
        Row(
            modifier = Modifier.width(100.dp).clickable {
                changeTheme(ThemeColor.BLUE)
            }.background(color = ThemeComposeTheme.color.secondary),
        ) {
            Text(style = ThemeComposeTheme.typography.bodyNormal16, text = "파랑 테마를 적용할꺼야")
        }
        Row(
            modifier = Modifier.width(100.dp).clickable {
                changeTheme(ThemeColor.YELLOW)
            }.background(color = ThemeComposeTheme.color.tertiary),
        ) {
            Text(style = ThemeComposeTheme.typography.bodyNormal12, text = "노랑 테마를 적용할꺼야")
        }
        Row(
            modifier = Modifier.width(100.dp).clickable {
                changeTheme(ThemeColor.GREEEN)
            }.background(color = ThemeComposeTheme.color.surface),
        ) {
            Text(
                style = ThemeComposeTheme.typography.bodyNormal16,
                text = "초록 테마를 적용할꺼야",
            )
        }
    }
}

enum class ThemeColor {
    RED, BLUE, YELLOW, GREEEN
}
