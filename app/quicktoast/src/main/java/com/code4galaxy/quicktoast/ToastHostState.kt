package com.code4galaxy.quicktoast

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow


/**
 * Decoupled state that the UI observes. Public API exposes `show(...)` methods
 * to enqueue toasts in a FIFO channel.
 */
class ToastHostState internal constructor() {
    private val channel = Channel<ToastData>(capacity = Channel.BUFFERED)
    internal val flow = channel.receiveAsFlow()


    suspend fun show(data: ToastData) { channel.send(data) }


    suspend fun show(
        message: String,
        type: ToastType = ToastType.DEFAULT,
        duration: ToastDuration = ToastDuration.Short,
        styleOverride: ToastStyle? = null,
    ) = show(ToastData(message, type, duration, styleOverride))


    // Convenience helpers
    suspend fun success(message: String, duration: ToastDuration = ToastDuration.Short) =
        show(message, ToastType.SUCCESS, duration)


    suspend fun error(message: String, duration: ToastDuration = ToastDuration.Long) =
        show(message, ToastType.ERROR, duration)


    suspend fun info(message: String, duration: ToastDuration = ToastDuration.Short) =
        show(message, ToastType.INFO, duration)


    suspend fun warning(message: String, duration: ToastDuration = ToastDuration.Long) =
        show(message, ToastType.WARNING, duration)
}