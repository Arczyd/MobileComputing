package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Activities App",
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 50.sp
                )

                Button(onClick = {
                    val navigate = Intent(this@MainActivity, Activity1::class.java)
                    startActivity(navigate)
                }) {
                    Text(stringResource(id = com.example.myapplication3.R.string.play))
                    Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }

