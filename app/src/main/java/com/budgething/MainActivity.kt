package com.budgething

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.budgething.ui.theme.BudgeThingTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.budgething.ViewModel.GreetingsViewModel
import com.budgething.ViewModel.SampleViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BudgeThingTheme {
                MainScreen()
            }
        }
    }
}



@Composable
fun Greetings(viewModel: GreetingsViewModel = viewModel()) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .height(270.dp),
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(10.dp),
        tonalElevation = 150.dp
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            var text by remember { mutableStateOf("") }
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Name") },
                singleLine = true
            )
            Button(
                onClick = {
                    viewModel.submitName(text)
                    text = ""
                }
            ) {
                Text("Submit")
            }

            Text("Hello ${ viewModel.name }")

        }
    }
}

@Composable
fun Counter(viewModel: SampleViewModel = viewModel()) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .height(270.dp),
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(10.dp),
        tonalElevation = 150.dp
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Box(
                modifier = Modifier
                    .width(viewModel.num.dp)
                    .height(20.dp)
                    .background(
                        MaterialTheme.colorScheme.secondary,
                        shape = RoundedCornerShape(5.dp)
                    )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {viewModel.incrementBy(10)},
                    enabled = viewModel.num <= 100
                ) {
                    Text("+")
                }

                Button(
                    onClick = {viewModel.decrementBy(10)},
                    enabled = viewModel.num >= 1
                ) {
                    Text("-")
                }
            }

            Button(
                onClick = {viewModel.resetNum()}
            ) {
                Text("Reset")
            }

        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Greetings()
        Counter()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BudgeThingTheme {
        MainScreen()
    }
}