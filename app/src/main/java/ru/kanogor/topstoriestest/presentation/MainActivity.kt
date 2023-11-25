package ru.kanogor.topstoriestest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kanogor.topstoriestest.domain.entity.Multimedia
import ru.kanogor.topstoriestest.presentation.theme.BlueProgress

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val multimediaList = remember {
                mutableStateOf(emptyList<Multimedia>())
            }
            val isLoading = remember {
                mutableStateOf(true)
            }
            LaunchedEffect(Unit) {
                viewModel.multimedia.collect {
                    multimediaList.value = it
                }
            }
            LaunchedEffect(Unit) {
                viewModel.isLoading.collect {
                    isLoading.value = it
                }
            }
            if (isLoading.value) {
                ProgressIndicatorScreen()
            } else
                MainScreen(multimediaList)
        }
    }
}

@Preview
@Composable
fun ProgressIndicatorScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            color = BlueProgress,
            modifier = Modifier
                .padding(16.dp)
                .width(64.dp)
                .height(64.dp)
        )
    }
}
