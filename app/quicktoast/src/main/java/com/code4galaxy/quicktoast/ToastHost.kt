package com.code4galaxy.quicktoast

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


enum class ToastAlignment { Top, Bottom }

@Composable
fun ToastHost(
    state: ToastHostState,
    modifier: Modifier = Modifier,
    alignment: ToastAlignment = ToastAlignment.Bottom,
    verticalOffsetDp: Int = 24,
    content: @Composable (ToastData) -> Unit = { data ->
        val style = data.styleOverride ?: ToastDefaults.styleFor(data.type)
        SimpleToast(message = data.message, style = style)
    }
) {
    val scope = rememberCoroutineScope()
    val density = LocalDensity.current


    var current by remember { mutableStateOf<ToastData?>(null) }
    var visible by remember { mutableStateOf(false) }
    var autoDismissJob by remember { mutableStateOf<Job?>(null) }


// Consume queue sequentially
    LaunchedEffect(state) {
        state.flow.collect { next ->
// If something showing, hide first
            if (visible) {
                visible = false
                delay(120)
            }
            current = next
            visible = true


            autoDismissJob?.cancel()
            autoDismissJob = scope.launch {
                delay(next.duration.value)
                visible = false
            }
        }
    }


    Box(modifier = modifier.fillMaxSize()) {
        val align = when (alignment) {
            ToastAlignment.Top -> Alignment.TopCenter
            ToastAlignment.Bottom -> Alignment.BottomCenter
        }
        val offset = with(density) { verticalOffsetDp.dp.toPx().toInt() }


        AnimatedVisibility(
            modifier = Modifier
                .align(align)
                .padding(horizontal = 16.dp)
                .padding(top = if (alignment == ToastAlignment.Top) verticalOffsetDp.dp else 0.dp,
                    bottom = if (alignment == ToastAlignment.Bottom) verticalOffsetDp.dp else 0.dp),
            visible = visible && current != null,
            enter = fadeIn(animationSpec = tween(150)) +
                    slideInVertically(animationSpec = tween(220)) { fullHeight ->
                        if (alignment == ToastAlignment.Bottom) fullHeight / 4 else -fullHeight / 4
                    },
            exit = fadeOut(animationSpec = tween(120)) +
                    slideOutVertically(animationSpec = tween(180)) { fullHeight ->
                        if (alignment == ToastAlignment.Bottom) fullHeight / 6 else -fullHeight / 6
                    }
        ) {
            current?.let { content(it) }
        }
    }
}