import androidx.compose.ui.window.ComposeUIViewController
import com.compose.weather.ui.App
import com.compose.weather.ui.FirstViewModel
import platform.UIKit.UIViewController

fun MainViewController(viewModel: FirstViewModel): UIViewController =
    ComposeUIViewController {
        App(viewModel = viewModel)
    }
