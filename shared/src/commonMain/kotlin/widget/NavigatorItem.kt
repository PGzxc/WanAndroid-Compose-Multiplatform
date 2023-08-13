package widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bean.TreeBean
import bean.TreeItemBean

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NavigatorItem(
    itemBean: TreeBean,
    onSelect: (itemBean: TreeItemBean) -> Unit = {},
) {
    Column(modifier = Modifier.fillMaxWidth().padding(top = 10.dp)) {
        if (!itemBean.children.isNullOrEmpty()) {
            FlowRow(modifier = Modifier.padding(horizontal = 10.dp)) {
                for (item in itemBean.children!!) {
                    LabelTextButton(
                        text = item.name ?: "android",
                        modifier = Modifier.padding(start = 5.dp, bottom = 5.dp),
                        onClick = { onSelect(item) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}