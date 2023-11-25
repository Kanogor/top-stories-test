package ru.kanogor.topstoriestest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kanogor.topstoriestest.presentation.theme.TopStoriesTestTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            viewModel.getInfo()
            TopStoriesTestTheme {
                MainScreen()
            }
        }
    }
}
