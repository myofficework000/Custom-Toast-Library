package com.code4galaxy.quicktoast

import androidx.compose.runtime.Immutable

@Immutable
data class ToastData(
    val message: String,
    val type: ToastType = ToastType.DEFAULT,
    val duration: ToastDuration = ToastDuration.Short,
    val styleOverride: ToastStyle? = null,
)
