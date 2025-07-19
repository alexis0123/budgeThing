package com.budgething.ui.components.topscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import com.budgething.data.model.Expense

@Composable
fun ExpenseDisplay(expenses: List<Expense>) {

    if (expenses.isNotEmpty()) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(expenses) { expense ->
                ExpenseCard(
                    name = expense.name,
                    amount = expense.amount,
                    onClick = {}
                )
            }
        }
    } else {
        Text(
            text = "No expenses yet",
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}