import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ui.main.NaviMainScreen
import ui.theme.AppTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun App(darkTheme:Boolean,dynamicColor:Boolean) {
    AppTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor,
    ) {
        Navigator(
            screen = NaviMainScreen,
        ) { navigator ->
            FadeTransition(navigator)
        }
    }

//    MaterialTheme {
//        Navigator(screen = NaviMainScreen) { navigator ->
//            FadeTransition(navigator)
//            //SlideTransition(navigator)
//        }
//    }
}

expect fun getPlatformName(): String