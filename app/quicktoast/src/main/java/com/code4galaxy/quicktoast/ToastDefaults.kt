package com.code4galaxy.quicktoast

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object ToastDefaults {
    @Composable
    fun styleFor(type: ToastType): ToastStyle {
        val palette = MaterialTheme.colorScheme
        return when (type) {
            ToastType.SUCCESS -> ToastStyle(
                background = Color(0xFF0F9D58),
                contentColor = Color.White
            )
            ToastType.ERROR -> ToastStyle(
                background = Color(0xFFDB4437),
                contentColor = Color.White
            )
            ToastType.WARNING -> ToastStyle(
                background = Color(0xFFF4B400),
                contentColor = Color(0xFF1D1B20)
            )
            ToastType.INFO -> ToastStyle(
                background = Color(0xFF4285F4),
                contentColor = Color.White
            )
            ToastType.DEFAULT -> ToastStyle(
                background = palette.inverseSurface,
                contentColor = palette.inverseOnSurface
            )
        }
    }
}