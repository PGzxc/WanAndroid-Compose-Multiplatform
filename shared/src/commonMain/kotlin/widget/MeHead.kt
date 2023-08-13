package widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import bean.MeInfoBean
import bean.UserInfo
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.store
import ui.screen.LoginScreen
import viewmodel.MineViewModel

/**
 * 我的——Widget——头部
 */
@Composable
fun MeHead(viewModel: MineViewModel) {
    val navigator = LocalNavigator.currentOrThrow

    val userInfo: UserInfo? by store.updates.collectAsState(UserInfo())

    Column() {
        //1-用户信息
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 30.dp, horizontal = 30.dp)
                .clickable {
                    navigator.push(LoginScreen)
                }) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier
                    .size(width = 80.dp, height = 80.dp)
                    .background(Color.LightGray, shape = CircleShape)
                    .padding(20.dp)
            )
            Text(
                text = if (userInfo != null) userInfo!!.username else "欢迎登录",
                modifier = Modifier.weight(1f).padding(horizontal = 5.dp)
            )
            Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = null)

        }
        Row {
            MeInfo(
                MeInfoBean(
                    name = "等级",
                    value = if (userInfo != null) viewModel.coinInfo.level.toString() else "—"
                ), modifier = Modifier.weight(1f)
            )
            MeInfo(
                MeInfoBean(
                    name = "排名",
                    value = if (userInfo != null) viewModel.coinInfo.rank else "—"
                ), modifier = Modifier.weight(1f)
            )
            MeInfo(
                MeInfoBean(
                    name = "收藏",
                    value = if (userInfo != null) userInfo?.collectIds?.size.toString() else "—"
                ), modifier = Modifier.weight(1f)
            )
            MeInfo(
                MeInfoBean(
                    name = "积分",
                    value = if (userInfo != null) viewModel.coinInfo.coinCount.toString() else "—"
                ), modifier = Modifier.weight(1f)
            )
        }
    }
}