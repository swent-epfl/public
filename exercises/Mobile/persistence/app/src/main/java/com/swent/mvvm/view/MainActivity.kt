package com.swent.mvvm.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.swent.mvvm.view.screen.CharacterListScreen
import com.swent.mvvm.view.theme.MVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMTheme {
                AppContent()
            }
        }
    }

    @Composable
    fun AppContent() {
        CharacterListScreen()
    }
}
