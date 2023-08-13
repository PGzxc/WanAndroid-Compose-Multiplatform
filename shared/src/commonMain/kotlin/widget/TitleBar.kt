package widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.theme.darkBackground
import ui.theme.darkError
import ui.theme.darkErrorContainer
import ui.theme.darkOnBackground
import ui.theme.darkOnError
import ui.theme.darkOnErrorContainer
import ui.theme.darkOnPrimary
import ui.theme.darkOnPrimaryContainer
import ui.theme.darkOnSecondary
import ui.theme.darkOnSecondaryContainer
import ui.theme.darkOnSurface
import ui.theme.darkOnSurfaceVariant
import ui.theme.darkOnTertiary
import ui.theme.darkOnTertiaryContainer
import ui.theme.darkOutline
import ui.theme.darkPrimary
import ui.theme.darkPrimaryContainer
import ui.theme.darkSecondary
import ui.theme.darkSecondaryContainer
import ui.theme.darkSurface
import ui.theme.darkSurfaceVariant
import ui.theme.darkTertiary
import ui.theme.darkTertiaryContainer

@Composable
fun TitleBar(title: String,
             leftIcon: ImageVector? = null,
             leftCallBack: (() -> Unit)? = null,
             rightIcon: ImageVector? = null,
             rightCallBack: (() -> Unit)? = null) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(darkBackground)
            .height(50.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(visible = true) {
            when (leftIcon == null) {
                true -> Spacer(Modifier.width(30.dp))
                else -> Icon(
                    imageVector = leftIcon ?: Icons.Default.ArrowBackIos,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            if (leftCallBack != null) {
                                leftCallBack()
                            }
                        }
                )
            }
        }

        Text(
            text = title,
            modifier = Modifier.weight(1f, true),
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 18.sp
        )
        AnimatedVisibility(visible = true) {
            when (rightIcon == null) {
                true -> Spacer(Modifier.width(30.dp))
                else -> Icon(
                    imageVector = rightIcon ?: Icons.Default.ArrowBackIos,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            if (rightCallBack != null) {
                                rightCallBack()
                            }
                        }
                )
            }
        }
    }
}

