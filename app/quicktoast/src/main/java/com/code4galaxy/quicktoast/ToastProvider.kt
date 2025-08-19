package com.code4galaxy.quicktoast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier


val LocalToastHostState = staticCompositionLocalOf<ToastHostState?> { null }

@Composable
fun ToastProvider(
    modifier: Modifier = Modifier,
    alignment: ToastAlignment = ToastAlignment.Bottom,
    content: @Composable () -> Unit
) {
    val state = rememberToastHostState()
    CompositionLocalProvider(LocalToastHostState provides state) {
        content()
        ToastHost(state = state, modifier = modifier, alignment = alignment) { data ->
// Default slot uses typed toast with icons
            TypedToast(data)
        }
    }
}