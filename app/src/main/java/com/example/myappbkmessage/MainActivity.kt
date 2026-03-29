package com.example.myappbkmessage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myappbkmessage.ui.theme.MyAppBKmessageTheme
import com.example.myappbkmessage.ui.theme.customColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppBKmessageTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Toxa(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Toxa( modifier: Modifier = Modifier) {
    Column(){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Text(
                text = "Hotel",
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        Text(
            text = "Оплата прошла успешно",
            color = MaterialTheme.customColors.onSuccess, // Белый днем, темный ночью
            modifier = Modifier
                .background(MaterialTheme.customColors.success) // Насыщенный днем, пастельный ночью
                .padding(16.dp)
        )
    }
}

