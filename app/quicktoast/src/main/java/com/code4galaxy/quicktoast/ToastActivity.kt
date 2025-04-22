package com.code4galaxy.quicktoast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.code4galaxy.quicktoast.ui.theme.LibarayDemoTheme
import kotlinx.coroutines.delay

class ToastActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LibarayDemoTheme {
             CustomToastComponent()
            }
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