package com.example.myappbkmessage.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CustomColors(
    val success: Color,
    val onSuccess: Color,
    val warning: Color,
    val onWarning: Color,
    val premiumBadge: Color,
    val socialVk: Color // Цвета брендов часто статичны
)

// 2. Создаем глобальный ключ (провайдер) с заглушками
val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(
        success = Color.Unspecified,
        onSuccess = Color.Unspecified,
        warning = Color.Unspecified,
        onWarning = Color.Unspecified,
        premiumBadge = Color.Unspecified,
        socialVk = Color.Unspecified
    )
}


val MaterialTheme.customColors: CustomColors
    @Composable
    @ReadOnlyComposable
    get() = LocalCustomColors.current


val lightCustomColors = CustomColors(
    success = Green40,       // Насыщенный зеленый для светлого фона
    onSuccess = Color.White,
    warning = Yellow50,
    onWarning = Neutral10,   // Темный текст для контраста с желтым
    premiumBadge = Purple40,
    socialVk = Color(0xFF0077FF) // Статичный бренд-цвет
)

val darkCustomColors = CustomColors(
    success = Green80,       // Пастельный зеленый для темного фона
    onSuccess = Neutral10,   // Темный текст на пастельном фоне
    warning = Yellow80,
    onWarning = Neutral10,
    premiumBadge = Purple80,
    socialVk = Color(0xFF0077FF) // Оставляем неизменным
)