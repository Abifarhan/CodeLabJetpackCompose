package com.abifarhan.codelabjetpackcompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abifarhan.codelabjetpackcompose.ui.theme.CodeLabJetpackComposeTheme

private var testing: String? = null

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        testing = "hoisting"
        setContent {
            CodeLabJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                    MyApp(this)
                    OnBoardingScreen()
                }
            }
        }
    }
}

@Composable
private fun MyApp(context: Context, names: List<String> = listOf("World", "Compose")) {

    Column {
        for (name in names) {
            Greeting(context = context, name = name)
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
fun Greeting(context: Context, name: String) {
    var expanded = remember { mutableStateOf(false) } //Don't do this

    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(
            vertical = 4.dp,
            horizontal = 8.dp
        )
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello,")
                Text(text = name)
            }
            OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "Show less" else "Show more")
                Toast.makeText(context, "this is the value $testing", Toast.LENGTH_SHORT).show()
            }
        }

    }
//    Image()
}

@Composable
fun OnBoardingScreen() {
//    TODO: This state should be hoisted
    val shouldShowOnBoarding by remember { mutableStateOf(true) }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basic Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = { /*TODO*/ }) 
            {
                Text(text = "Continue")
            }

        }
    }

}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    CodeLabJetpackComposeTheme {
//        MyApp()
    }
}