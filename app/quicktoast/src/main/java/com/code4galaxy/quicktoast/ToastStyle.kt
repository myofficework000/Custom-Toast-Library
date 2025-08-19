package com.code4galaxy.quicktoast

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Immutable
data class ToastStyle(
    val background: Color,
    val contentColor: Color,
    val borderColor: Color = Color.Transparent,
    val elevation: Dp = 8.dp,
    val textStyle: TextStyle = TextStyle(fontSize = 14.sp),
    val cornerRadius: Dp = 16.dp
)