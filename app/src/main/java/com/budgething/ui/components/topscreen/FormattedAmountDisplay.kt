package com.budgething.ui.components.topscreen

import android.icu.util.Currency
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun FormattedAmountDisplay(amount: String, fontSize: Int, color: Color, format: String = "") {

    val formattedAmount = amount.toLongOrNull()?.let {
        "$format %,d".format(it)
    } ?: amount

    Text(
        formattedAmount, fontSize = fontSize.sp,
        color = color
    )

}