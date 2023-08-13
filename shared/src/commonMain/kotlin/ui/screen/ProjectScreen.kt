package ui.screen

import action.StateAction
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import state.UIState
import viewmodel.ProjectViewModel
import widget.ProjectWidget

//object ProjectScreen :Screen{
//    @Composable
//    override fun Content() {
//       val projectViewModel: ProjectViewModel = ProjectViewModel()
//    }
//
//}

@Composable
fun ProjectScreen(projectViewModel: ProjectViewModel = ProjectViewModel()) {
    val uiState by projectViewModel.uiState.collectAsState()

    LaunchedEffect(true) {
        projectViewModel.getProjectListData()
    }

    when (uiState) {
        is UIState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

        is UIState.Error -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text((uiState as UIState.Error).message, modifier = Modifier.clickable {
                projectViewModel.dispatch(StateAction.FetchData)
            })
        }

        is UIState.Success -> ProjectWidget(viewModel = projectViewModel)
    }
}