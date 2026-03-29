package com.example.myappbkmessage.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class AppBorders(
    val thin: BorderStroke,
    val active: BorderStroke,
    val error: BorderStroke
)

// 2. Создаем Local-провайдер с пустыми значениями по умолчанию (заглушками)
val LocalAppBorders = staticCompositionLocalOf {
    AppBorders(
        thin = BorderStroke(0.dp, Color.Unspecified),
        active = BorderStroke(0.dp, Color.Unspecified),
        error = BorderStroke(0.dp, Color.Unspecified)
    )
}

// 3. Делаем красивое расширение для MaterialTheme, чтобы вызывать обводки привычным образом
val MaterialTheme.borders: AppBorders
    @Composable
    @ReadOnlyComposable
    get() = LocalAppBorders.current