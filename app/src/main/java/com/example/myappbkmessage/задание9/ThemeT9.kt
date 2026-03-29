package kz.misal.message.ui.theme

import android.os.Build
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.myappbkmessage.ui.theme.AppBorders
import com.example.myappbkmessage.задание9.Black100
import com.example.myappbkmessage.задание9.Black80
import com.example.myappbkmessage.задание9.Error70
import com.example.myappbkmessage.задание9.Error80
import com.example.myappbkmessage.задание9.OnWarningContainer
import com.example.myappbkmessage.задание9.Primary10
import com.example.myappbkmessage.задание9.Primary100
import com.example.myappbkmessage.задание9.Primary5
import com.example.myappbkmessage.задание9.Primary80
import com.example.myappbkmessage.задание9.Success40
import com.example.myappbkmessage.задание9.Success80
import com.example.myappbkmessage.задание9.SurfaceDark0
import com.example.myappbkmessage.задание9.SurfaceDark1
import com.example.myappbkmessage.задание9.SurfaceDark2
import com.example.myappbkmessage.задание9.SurfaceLight0
import com.example.myappbkmessage.задание9.SurfaceLight1
import com.example.myappbkmessage.задание9.TextPrimary
import com.example.myappbkmessage.задание9.TextPrimaryDark
import com.example.myappbkmessage.задание9.TextSecondary
import com.example.myappbkmessage.задание9.TextSecondaryDark
import com.example.myappbkmessage.задание9.Warning60
import com.example.myappbkmessage.задание9.Warning90
import com.example.myappbkmessage.задание9.WarningContainer


private val DarkColorSchemeT9 = darkColorScheme(
    primary = Primary10,
    onPrimary = TextPrimaryDark,

    primaryContainer = Primary100,
    onPrimaryContainer = Primary5,

    secondary = Warning60,
    onSecondary = TextPrimary,

    secondaryContainer = WarningContainer,
    onSecondaryContainer = OnWarningContainer,

    tertiary = Success40,
    onTertiary = TextPrimary,

    background = SurfaceDark0,
    onBackground = TextPrimaryDark,

    surface = SurfaceDark1,
    onSurface = TextPrimaryDark,

    surfaceVariant = SurfaceDark2,
    onSurfaceVariant = TextSecondaryDark,

    error = Error70,
    onError = TextPrimaryDark
)

private val LightColorSchemeT9: ColorScheme
    get() = lightColorScheme(
        primary = Primary80,
        onPrimary = Black100,

        primaryContainer = Primary100,
        onPrimaryContainer = TextPrimaryDark,

        secondary = Warning60,
        onSecondary = Black100,

        secondaryContainer = Warning90,
        onSecondaryContainer = Black100,

        tertiary = Success80,
        onTertiary = Black100,

        background = SurfaceLight0,
        onBackground = TextPrimary,

        surface = SurfaceLight0,
        onSurface = Black80,

        surfaceVariant = SurfaceLight1,
        onSurfaceVariant = TextSecondary,

        error = Error80,
        onError = Black100
    )

val LocalMessageIconSize = compositionLocalOf { 20.dp }

@Composable
fun MessageThemeT9(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorSchemeT9
        else -> LightColorSchemeT9
    }

    // Интегрируем дополнительные цвета в MaterialTheme
//    val customColors = if (darkTheme) darkCustomColors else lightCustomColors

    val borders = remember(colorScheme) {
        AppBorders(
            thin = BorderStroke(1.dp, colorScheme.outlineVariant),
            active = BorderStroke(2.dp, colorScheme.primary),
            error = BorderStroke(2.dp, colorScheme.error)
        )
    }

    CompositionLocalProvider(
//        LocalAppBorders provides borders,
//        LocalAppSpacing provides AppSpacing(),
//        LocalCustomColors provides customColors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
//            typography = AppTypography,
            content = content,
//            shapes = AppShapes // <-- Подключаем формы
        )
    }
}