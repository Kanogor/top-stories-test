package ru.kanogor.topstoriestest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.kanogor.topstoriestest.presentation.theme.TopStoriesTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopStoriesTestTheme {
                MainScreen()
            }
        }
    }
}
