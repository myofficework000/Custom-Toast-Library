package com.code4galaxy.quicktoast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup

@Composable
fun CustomToast(
    message: String,
    type: ToastType = ToastType.INFO
) {
    Popup(alignment = Alignment.BottomCenter, offset = IntOffset(0, -100)) {
        Box(
            modifier = Modifier
                .background(getToastColor(type))
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = message)
        }
    }
}

fun getToastColor(type: ToastType): Color = when (type) {
    ToastType.INFO -> Color(0xFF0091EA)
    ToastType.SUCCESS -> Color(0xFF4CAF50)
    ToastType.ERROR -> Color(0xFFF44336)
}
