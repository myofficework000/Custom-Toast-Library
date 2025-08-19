package com.code4galaxy.quicktoast

/** Duration in milliseconds */
@JvmInline
value class ToastDuration(val value: Long) {
    companion object {
        val Short = ToastDuration(1800L)
        val Long = ToastDuration(3200L)
        fun custom(ms: Long) = ToastDuration(ms.coerceAtLeast(500L))
    }
}