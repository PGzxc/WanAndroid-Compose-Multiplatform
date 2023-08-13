package ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen

object NaviMainScreen:Screen {
    @Composable
    override fun Content() {
        MainScreen(modifier = Modifier.fillMaxSize())
        //MainScreen.Content()
    }
}