import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Desktop"

//@Composable fun MainView() = App()
@Composable
fun MainView() = App(
    darkTheme = true,
    dynamicColor = false,
)

@Preview
@Composable
fun AppPreview() {
    //App()
    App(
        darkTheme = true,
        dynamicColor = false,
    )
}