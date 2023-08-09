import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Android"

//@Composable fun MainView() = App()

@Composable fun MainView() = App(
    darkTheme = true,
    dynamicColor = false,
)
