package widget

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import viewmodel.ProjectViewModel

@Composable
internal fun ProjectChileScreen(
    viewModel: ProjectViewModel,
    cid: Long,
) {

    LaunchedEffect(true) {
        viewModel.projectItemListData.clear()
        viewModel.currentPage.value = 0
        viewModel.getProjectItemListData(page = viewModel.currentPage.value, cid = cid)
    }
    val projectItemListBean = viewModel.projectItemListData

    LazyColumn {
        itemsIndexed(projectItemListBean) { index, temp ->
            ArticleListItem(item = temp, itemClick = { url ->

            }) {

            }
        }
    }

}