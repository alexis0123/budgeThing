package com.budgething.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.budgething.ViewModel.SampleViewModel

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

