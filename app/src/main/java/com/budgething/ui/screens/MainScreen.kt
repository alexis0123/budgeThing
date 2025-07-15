package com.budgething.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.budgething.ui.theme.BudgeThingTheme
import com.budgething.R
import com.budgething.ui.components.ConfirmAmount
import com.budgething.ui.components.FormattedAmountDisplay
import com.budgething.ui.components.Key

@Composable
fun MainScreen() {
    var amount by remember { mutableStateOf("")}
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd
            ) {

                Row(modifier = Modifier.padding(horizontal = 15.dp)) {
                    FormattedAmountDisplay(amount)
                }
            }

            Column(
                modifier = Modifier
                    .weight(1.5f)
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                val keypad = listOf(
                    listOf("7", "8", "9", "⌫"),
                    listOf("4", "5", "6", "C"),
                    listOf("1", "2", "3", "→"),
                    listOf("00", "0", ".", "✔")
                )

                Divider()

                keypad.forEach { row ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        row.forEach { label ->
//                            Key(label) {
//                                when (label) {
//                                    "C" -> amount = ""
//                                    "⌫" -> amount = amount.dropLast(1)
//                                }
//                            }
                            when(label) {
                                "C" -> Key(label) { amount = "" }
                                "✔" -> ConfirmAmount( amount.isNotEmpty() ) {}
                                "⌫" -> Key(label) { amount = amount.dropLast(1) }
                                else -> Key(label) { amount += label }
                            }
                        }
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    BudgeThingTheme {
        MainScreen()
    }
}