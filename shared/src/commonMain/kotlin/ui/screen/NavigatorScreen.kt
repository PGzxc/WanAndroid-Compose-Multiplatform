package ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun NavigatorScreen() {
    Box() {
        Text("NavigatorScreen", modifier = Modifier.fillMaxSize(),textAlign = TextAlign.Center)
    }
}