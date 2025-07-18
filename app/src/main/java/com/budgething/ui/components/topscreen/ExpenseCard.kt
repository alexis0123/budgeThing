package com.budgething.ui.components.topscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressLint("DefaultLocale")
@Composable
fun ExpenseCard(name: String, amount: Double, onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Text(
            text = String.format("₱%,.2f", amount),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}
