package com.budgething.ui.components.topscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.budgething.ExpenseViewModel

@Composable
fun TopScreen(amount: String, expenseViewModel: ExpenseViewModel) {
    val expenses by expenseViewModel.expenses.collectAsState()
    val total by expenseViewModel.total.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .weight(.6f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            if (expenses.isNotEmpty()) {
                Button(
                    onClick = { expenseViewModel.clearAll() },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error)
                ) { Text("Clear", color = MaterialTheme.colorScheme.onError) }
            }
            ExpenseDisplay(expenses)
        }

        Box(
            modifier = Modifier
                .weight(.3f)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        ) {
            FormattedAmountDisplay(amount, 50, MaterialTheme.colorScheme.onBackground)
        }

        Box(
            modifier = Modifier
                .weight(.1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            FormattedAmountDisplay(total.toString(), 20, MaterialTheme.colorScheme.onSecondaryContainer, "₱")
        }

    }
    Spacer(modifier = Modifier.height(20.dp))
}