package com.code4galaxy.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.code4galaxy.quicktoast.CustomToast
import com.code4galaxy.quicktoast.ToastType
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomToastComponent()
        }
    }
}


@Composable
fun CustomToastComponent() {
    var showToast by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { showToast = true }){
            Text(text = "Show Toast")
        }

        if (showToast){
            CustomToast(message = "This is a toast message", ToastType.SUCCESS)

            LaunchedEffect(Unit){
                delay(2000)
                showToast = false
            }
        }
    }
}