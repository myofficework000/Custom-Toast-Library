package com.code4galaxy.quicktoast.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

object ColorUtils {
    fun toHex(red: Int, green: Int, blue: Int): String {
        return String.format("#%02x%02x%02x", red, green, blue)
    }
}