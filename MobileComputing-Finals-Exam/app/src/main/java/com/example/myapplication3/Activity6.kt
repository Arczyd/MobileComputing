package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buildagrid.data.DataSource
import com.example.buildagrid.model.Topic
import com.example.myapplication3.ui.theme.MyApplication3Theme

class Activity6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopicGrid(
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.padding_small),
                            top = dimensionResource(R.dimen.padding_small),
                            end = dimensionResource(R.dimen.padding_small),
                        )
                    )
                }
                Column(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center).padding(0.dp,650.dp,0.dp,0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(onClick = {
                        val navigate = Intent(this@Activity6, MainActivity::class.java)
                        startActivity(navigate)
                    }) {
                        Text(stringResource(id = R.string.back))
                        Spacer(modifier = Modifier.height(16.dp))

                    }
                }
            }
        }
    }
}

@Composable
fun TopicGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier
    ) {
        items(DataSource.topics) { topic ->
            TopicCard(topic)
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card {
        Row {
            Box {
                Image(
                    painter = painterResource(id = topic.imageRes),
                    contentDescription = null,
                    modifier = modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }

            Column {
                Text(
                    text = stringResource(id = topic.name),
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_small)
                    )
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = dimensionResource(R.dimen.padding_medium))
                    )
                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                    )
                }
            }
        }
    }
}