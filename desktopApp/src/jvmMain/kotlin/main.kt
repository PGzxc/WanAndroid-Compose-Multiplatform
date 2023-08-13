import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.appStorage
import net.harawata.appdirs.AppDirsFactory

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "WanAndroid") {
        //MainView()
        appStorage = AppDirsFactory.getInstance().getUserDataDir("io.github.xxfast.nytimes", "1.0.0", "xxfast")
        App(
            darkTheme = true,
            dynamicColor = true,
        )
    }
}