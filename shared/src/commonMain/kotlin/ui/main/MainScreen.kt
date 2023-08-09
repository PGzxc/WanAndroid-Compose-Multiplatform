package ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ui.screen.MainScreen
import ui.screen.MessageScreen
import ui.screen.MineScreen
import ui.screen.NavigatorScreen
import ui.screen.ProjectScreen

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("首页", "导航", "项目", "消息", "我的")

    Column {
        Box(modifier = Modifier.weight(1f)) {
            when (selectedItem) {
                0 -> MainScreen()
                1 -> NavigatorScreen()
                2 -> ProjectScreen()
                3 -> MessageScreen()
                4 -> MineScreen()
            }
        }
        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        when (index) {
                            0 -> Icon(Icons.Default.Home, contentDescription = item)
                            1 -> Icon(Icons.Default.List, contentDescription = item)
                            2 -> Icon(Icons.Default.Build, contentDescription = item)
                            3 -> Icon(Icons.Filled.MailOutline, contentDescription = item)
                            4 -> Icon(Icons.Filled.Person, contentDescription = item)
                        }
                    },
                    label = { Text(item) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                    alwaysShowLabel = true

                )
            }
        }
    }


}