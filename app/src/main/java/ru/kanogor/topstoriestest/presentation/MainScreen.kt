package ru.kanogor.topstoriestest.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ru.kanogor.topstoriestest.domain.entity.Multimedia
import ru.kanogor.topstoriestest.presentation.theme.GreyBackground

@Composable
fun MainScreen(multimediaList: MutableState<List<Multimedia>>) {
    LazyColumn(modifier = Modifier.background(color = GreyBackground)) {
        itemsIndexed(items = multimediaList.value) { _, item ->
            MultimediaItem(item = item)
        }
    }

}

@Composable
fun MultimediaItem(item: Multimedia) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, top = 8.dp),
                model = item.url,
                contentDescription = "${item.caption} image"
            )
            Text(
                text = item.caption,
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

