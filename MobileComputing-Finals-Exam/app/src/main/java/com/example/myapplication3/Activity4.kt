package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.myapplication3.ui.theme.MyApplication3Theme

class Activity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceRollApp()
                }
                Column(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center).padding(0.dp,650.dp,0.dp,0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(onClick = {
                        val navigate = Intent(this@Activity4, Activity5::class.java)
                        startActivity(navigate)
                    }) {
                        Text(stringResource(id = R.string.act5))
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun DiceRollApp(){
    DiceWithButtonAndImage()
}


@Composable
fun DiceWithButtonAndImage (modifier: Modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center))
{
    var result by remember { mutableStateOf (1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = result.toString()
        )

        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(R.string.roll))
            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}