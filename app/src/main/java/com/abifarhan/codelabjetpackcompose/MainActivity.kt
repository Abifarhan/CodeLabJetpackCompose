package com.abifarhan.codelabjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abifarhan.codelabjetpackcompose.ui.theme.CodeLabJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeLabJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
                    MyApp()
                }
            }
        }
    }
}

@Composable
private fun MyApp(names: List<String> = listOf("World","Compose")) {
    
    Column {
        for (name in names) {
            Greeting(name = name)
        }
    }
//    androidx.compose.material.Surface(color = MaterialTheme.colors.background) {
//        Greeting(name = "Android New")
//    }
//    Column {
//        Text(text = "First row")
//        Text(text = "Second row")
//    }
}

@Composable
fun Greeting(name: String) {
    androidx.compose.material.Surface(color = MaterialTheme.colors.primary) {
        Column(modifier = Modifier.padding(24.dp)) {
//            Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
            Text(text = "Hello,")
            Text(text = name)
        }
    }
//    Image()
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    CodeLabJetpackComposeTheme {
        MyApp()
    }
}