package com.budgething.ui.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.budgething.ExpenseViewModel
import java.time.temporal.TemporalAmount

@Composable
fun CancelRecordButton(
    dismiss: () -> Unit,
    mainCategory: String,
    subCategory: String,
    name: String,
    amount: Double,
    viewModel: ExpenseViewModel
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(
            onClick = dismiss,
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 5.dp,
                pressedElevation = 15.dp
            ),
            modifier = Modifier
                .height(50.dp)
        ) { Text("Cancel", color = MaterialTheme.colorScheme.onSecondary) }

        Button(
            enabled = mainCategory.isNotEmpty() && subCategory.isNotEmpty() && name.isNotEmpty(),
            onClick = {
                viewModel.addExpense(mainCategory, subCategory, name, amount)
                dismiss()
            },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 5.dp,
                pressedElevation = 15.dp
            ),
            modifier = Modifier
                .height(50.dp)
        ) { Text("Record", color = MaterialTheme.colorScheme.onPrimary) }

    }
}