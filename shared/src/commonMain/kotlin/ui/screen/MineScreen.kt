package ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MineScreen() {
    Box() {
        Text("MainScreen", modifier = Modifier.fillMaxSize(),textAlign = TextAlign.Center)
    }
}