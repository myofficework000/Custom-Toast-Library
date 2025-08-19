package com.code4galaxy.quicktoast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberToastHostState(): ToastHostState = remember { ToastHostState() }