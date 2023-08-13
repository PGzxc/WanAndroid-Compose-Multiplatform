package widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import bean.MeInfoBean


/**
 * @desc：我的-等级-view
 */

@Composable
fun MeInfo(meInfoBean: MeInfoBean, infoClick: () -> Unit = {}, modifier: Modifier) {
    Column(
        modifier = modifier.clickable { infoClick.invoke() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = meInfoBean.name ?: "—",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = if (meInfoBean.value.isNullOrBlank()) "—" else meInfoBean.value!!,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun Preview_MeInfo() {
    MeInfo(MeInfoBean(name = "等级", value = "17"), modifier = Modifier)
}