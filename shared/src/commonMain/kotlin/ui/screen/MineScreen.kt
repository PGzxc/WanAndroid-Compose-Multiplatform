package ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import bean.UserInfo
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import data.store
import viewmodel.LoginViewModel
import viewmodel.MineViewModel
import widget.HeadTools
import widget.MeHead
import widget.TitleBar

object MineScreen : Screen {
    @Composable
    override fun Content() {
        //val viewModel: MineViewModel = MineViewModel()
        val viewModel = rememberScreenModel { MineViewModel() }
        val userInfo: UserInfo? by store.updates.collectAsState(UserInfo())
        LaunchedEffect(true) {
            if (userInfo != null) {
                viewModel.getCoinInfo()
            }
        }

        Column {
            TitleBar(title = "我的", rightIcon = Icons.Default.Settings, rightCallBack = {
            })
            MeHead(viewModel = viewModel)
            HeadTools(viewModel = viewModel)
        }
    }
}

@Composable
fun MineScreen(viewModel: MineViewModel = MineViewModel()) {

    Column {
        TitleBar(title = "我的", rightIcon = Icons.Default.Settings, rightCallBack = {
        })
        MeHead(viewModel = viewModel)
        HeadTools(viewModel = viewModel)
    }
}