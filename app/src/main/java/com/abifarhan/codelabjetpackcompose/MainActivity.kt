package com.abifarhan.codelabjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
                MyApp()
            }
        }
    }
}


//@Composable
//private fun MyApp() {
//    var shouldShowOnBoarding by remember { mutableStateOf(true) }
//
//    if (shouldShowOnBoarding) {
//        OnBoardingScreen(onContinueClicked = {
//            shouldShowOnBoarding = false
//        })
//    } else {
//        Greetings()
//    }
//}
//
//@Composable
//fun OnBoardingScreen(onContinueClicked: () -> Unit) {
////    TODO: This state should be hoisted
//
//    Surface {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text("Welcome to the Basic Codelab!")
//            Button(
//                modifier = Modifier.padding(vertical = 24.dp),
//                onClick = { onContinueClicked })
//            {
//                Text(text = "Continue")
//            }
//
//        }
//    }
//
//}
//
//@Composable
//fun Greetings(names: List<String> = List(1000) { "$it" }) {
//    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
//        items(items = names) { name ->
//            Greeting(name = name)
//        }
//    }
////    Column(modifier = Modifier.padding(vertical = 4.dp)) {
////        for (name in names) {
////            Greeting(name = name)
////        }
////    }
//}
//
//@Composable
//fun Greeting(name: String) {
//    var expanded by remember { mutableStateOf(false) } //Don't do this
//
////    val extraPadding = if (expanded.value) 48.dp else 0.dp
//    val extraPadding by animateDpAsState(
//        if (expanded) 48.dp else 0.dp
//    )
//    Surface(
//        color = MaterialTheme.colors.primary,
//        modifier = Modifier.padding(
//            vertical = 4.dp,
//            horizontal = 8.dp
//        )
//    ) {
//        Row(modifier = Modifier.padding(24.dp)) {
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(bottom = extraPadding)
//            ) {
//                Text(text = "Hello,")
//                Text(text = name)
//            }
//            OutlinedButton(
//                onClick = { expanded = !expanded }
//            )
//            {
//                Text(if (expanded) "Show less" else "Show more")
////                Toast.makeText(context, "this is the value $testing", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//    }
////    Image()
//}
//
//
//@Preview(showBackground = true, widthDp = 320)
//@Composable
//fun DefaultPreview() {
//    CodeLabJetpackComposeTheme {
//        MyApp()
////        OnBoardingScreen()
//    }
//}


//here the new

@Composable
fun MyApp() {

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {
        Greetings()
    }
}

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
        }
    }
}

@Composable
private fun Greetings(names: List<String> = List(1000) { "$it" } ) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    CodeLabJetpackComposeTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

@Composable
private fun Greeting(name: String) {

    var expanded by remember { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(
                onClick = { expanded = !expanded }
            ) {
                Text(if (expanded) "Show less" else "Show more")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    CodeLabJetpackComposeTheme {
        Greetings()
    }
}