package com.budgething.ui.components.keypad

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.budgething.ui.components.keypad.NumKeyViewModel

@Composable
fun KeyPad(
    onConfirm: () -> Unit,
    viewModel: NumKeyViewModel = viewModel()
) {

    val amount = viewModel.amount.collectAsState()

    val keypad = listOf(
        listOf("7", "8", "9", "⌫"),
        listOf("4", "5", "6", "C"),
        listOf("1", "2", "3", "→"),
        listOf("00", "0", ".", "✔")
    )



    keypad.forEach { row ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            row.forEach { label ->
                when(label) {
                    "0" -> Key(label) { viewModel.addZero() }
                    "00" -> Key(label) { viewModel.addTwoZeros() }
                    "." -> Key(label) { viewModel.addDot() }
                    "⌫" -> Key(label) { viewModel.deleteLast() }
                    "C" -> Key(label) { viewModel.deleteAll() }
                    "→" -> Confirm("→", amount.value.isNotEmpty() ) {}
                    "✔" -> Confirm("✔", amount.value.isNotEmpty() ) {
                        onConfirm()
                    }
                    else -> Key(label) { viewModel.addDigit(label) }
                }
            }
        }
    }
}