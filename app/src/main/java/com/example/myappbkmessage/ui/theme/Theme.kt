package com.example.myappbkmessage.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

//private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40
//
//    /* Other default colors to override
//    background = Color(0xFFFFFBFE),
//    surface = Color(0xFFFFFBFE),
//    onPrimary = Color.White,
//    onSecondary = Color.White,
//    onTertiary = Color.White,
//    onBackground = Color(0xFF1C1B1F),
//    onSurface = Color(0xFF1C1B1F),
//    */
//)

private val LightColorScheme = lightColorScheme(
    // --- ОСНОВНЫЕ ЦВЕТА БРЕНДА ---
    primary = Blue40,               // Главные кнопки (Brand Blue)
    onPrimary = Color.White,        // Текст на главных кнопках
    primaryContainer = Blue10,      // Темно-синяя верхняя панель
    onPrimaryContainer = Color.White,

    // --- ВТОРОСТЕПЕННЫЕ АКЦЕНТЫ ---
    secondary = Yellow50,           // Жёлтый акцент (звезды, бейджи)
    onSecondary = Neutral10,        // Текст на желтом (лучше темный для контраста)
    secondaryContainer = Yellow50.copy(alpha = 0.2f), // Светло-желтый фон
    onSecondaryContainer = Neutral10,

    // --- СТАТУСЫ ---
    tertiary = Green40,             // Зеленый для позитивных статусов (Deal)
    onTertiary = Color.White,
    error = Red40,                  // Красный (Alerts, зачеркнутая цена)
    onError = Color.White,

    // --- ПОВЕРХНОСТИ И ФОНЫ ---
    background = Neutral95,         // Общий фон приложения
    onBackground = Neutral10,       // Основной текст на фоне

    surface = Color.White,          // Фон карточек (светлее фона приложения)
    onSurface = Neutral10,          // Текст на карточках

    surfaceVariant = Neutral90,     // Серые обводки, фоны неактивных элементов
    onSurfaceVariant = Neutral40    // Второстепенный текст (адрес, приписки)
)

@Composable
fun MyAppBKmessageTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val customColors = if (darkTheme) darkCustomColors else lightCustomColors

    // Передаем наши кастомные цвета вниз по дереву
    CompositionLocalProvider(
        // Перечисляем через запятую
        LocalCustomColors provides customColors
    ) {
        // Вызываем стандартную тему M3 внутри
        MaterialTheme(
            colorScheme = colorScheme,
            shapes = AppShapes,
            content = content
        )
    }
}