package ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import viewmodel.HomeViewModel
import viewmodel.LoginViewModel
import widget.TextInput
import widget.TitleBar

object LoginScreen:Screen{

    @Composable
    override fun Content() {
        var userName by rememberSaveable { mutableStateOf("") }
        var passWord by rememberSaveable { mutableStateOf("") }
        var rePassWord by rememberSaveable { mutableStateOf("") }
        var isLogin by rememberSaveable { mutableStateOf(true) }
        val viewModel: LoginViewModel = LoginViewModel()
        val homeViewModel = rememberScreenModel { LoginViewModel() }
        val navigator = LocalNavigator.currentOrThrow

        Column {
            TitleBar(
                leftIcon = Icons.Default.ArrowBackIos,
                title = if (isLogin) "登录" else "注册",
                leftCallBack = {
                    //navigator.push(MineScreen)
                    navigator.pop()
                })
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextInput(
                    text = userName,
                    label = "请输入用户名",
                    leadingIcon = Icons.Default.Person,
                ) { it ->
                    userName = it
                }
                Spacer(modifier = Modifier.height(10.dp))
                TextInput(
                    text = passWord,
                    label = "请输入密码",
                    leadingIcon = Icons.Default.Lock,
                    keyboardType = KeyboardType.Password,
                    isPassword = true
                ) { it ->
                    passWord = it
                }
                Spacer(modifier = Modifier.height(10.dp))
                AnimatedVisibility(visible = !isLogin) {
                    TextInput(
                        text = rePassWord,
                        label = "请输入确认密码",
                        leadingIcon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        isPassword = true
                    ) { it ->
                        rePassWord = it
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp), onClick = {
                when (isLogin) {
                    true -> viewModel.login(userName, passWord,navigator)
                    else -> viewModel.register(userName, passWord, rePassWord,navigator)
                }
                }) {
                    Text(text = if (isLogin) "登录" else "注册")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = if (isLogin) "没有账号，去注册" else "已有账号，去登录",
                    modifier = Modifier
                        .background(Color.LightGray, shape = RoundedCornerShape(5.dp))
                        .padding(horizontal = 20.dp, vertical = 2.dp)
                        .clickable {
                            userName = ""
                            passWord = ""
                            rePassWord = ""
                            isLogin = !isLogin
                        })
            }
        }
    }

}

//@Composable
//fun LoginScreen11(viewModel: LoginViewModel = LoginViewModel()):Screen {
//
//
//
//}