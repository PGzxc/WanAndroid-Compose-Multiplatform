import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Android"

//@Composable fun MainView() = App()

@Composable fun MainView() = App(
    darkTheme = false,
    dynamicColor = true,
)
