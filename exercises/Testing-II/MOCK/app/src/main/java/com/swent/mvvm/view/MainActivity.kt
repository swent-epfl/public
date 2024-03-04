package com.swent.mvvm.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.swent.mvvm.view.screen.CharacterListScreen
import com.swent.mvvm.view.theme.MVVMTheme
import com.swent.mvvm.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val characterViewModel:CharacterViewModel by viewModels()
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
        CharacterListScreen(characterViewModel)
    }
}
