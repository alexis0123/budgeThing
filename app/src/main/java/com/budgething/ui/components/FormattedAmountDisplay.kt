package com.budgething.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.sp

@Composable
fun FormattedAmountDisplay(amount: MutableState<String>) {

    val formattedAmount = amount.value.toLongOrNull()?.let {
        "%,d".format(it)
    } ?: amount.value

    Text(
        formattedAmount, fontSize = 40.sp,
        color = MaterialTheme.colorScheme.onBackground
    )

}