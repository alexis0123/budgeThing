package com.budgething.ui.components.topscreen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun FormattedAmountDisplay(amount: String) {

    val formattedAmount = amount.toLongOrNull()?.let {
        "%,d".format(it)
    } ?: amount

    Text(
        formattedAmount, fontSize = 40.sp,
        color = MaterialTheme.colorScheme.onBackground
    )

}