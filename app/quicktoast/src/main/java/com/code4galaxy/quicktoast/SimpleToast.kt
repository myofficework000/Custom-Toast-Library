package com.code4galaxy.quicktoast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun SimpleToast(
    message: String,
    style: ToastStyle,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(style.cornerRadius)


    Row(
        modifier = modifier
            .shadow(elevation = style.elevation, shape = shape, clip = false)
            .background(style.background, shape)
            .padding(horizontal = 14.dp, vertical = 12.dp)
            .semantics { contentDescription = "Toast" },
        horizontalArrangement = Arrangement.Center
    ) {
        val iconTint = style.contentColor
        val icon = when (style.background) {
// Icon selection will be driven by color; for better control, supply composable slot in host
            else -> null
        }
// We show icons by mapping to types through a convenience composable below
        Text(
            text = message,
            color = style.contentColor,
            style = MaterialTheme.typography.bodyMedium.merge(style.textStyle),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Composable
fun TypedToast(
    data: ToastData,
    modifier: Modifier = Modifier
) {
    val style = data.styleOverride ?: ToastDefaults.styleFor(data.type)
    val shape = RoundedCornerShape(style.cornerRadius)
    val icon = when (data.type) {
        ToastType.SUCCESS -> Icons.Default.CheckCircle
        ToastType.ERROR -> Icons.Default.Close
        ToastType.WARNING -> Icons.Default.Warning
        ToastType.INFO -> Icons.Default.Info
        ToastType.DEFAULT -> null
    }


    Row(
        modifier = modifier
            .shadow(elevation = style.elevation, shape = shape, clip = false)
            .background(style.background, shape)
            .padding(horizontal = 14.dp, vertical = 12.dp)
            .semantics { contentDescription = "Toast" },
        horizontalArrangement = Arrangement.Center
    ) {
        if (icon != null) {
            Icon(imageVector = icon, contentDescription = null, tint = style.contentColor)
            Spacer(Modifier.width(8.dp))
        }
        Text(
            text = data.message,
            color = style.contentColor,
            style = MaterialTheme.typography.bodyMedium.merge(style.textStyle),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}