package com.budgething.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.budgething.ui.theme.BudgeThingTheme
import com.budgething.ui.components.keypad.Confirm
import com.budgething.ui.components.FormattedAmountDisplay
import com.budgething.ui.components.keypad.Key
import com.budgething.ui.components.keypad.KeyPad
import com.budgething.ui.dialog.ConfirmAmountDialog

@Composable
fun MainScreen() {

    var amount by remember { mutableStateOf("")}
    var showConfirmAmountDialog by remember { mutableStateOf(false) }

    ConfirmAmountDialog(showConfirmAmountDialog, amount) {
        showConfirmAmountDialog = false

    }
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

            Divider()

            Column(
                modifier = Modifier
                    .weight(1.5f)
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                KeyPad({
                    showConfirmAmountDialog = true
                })
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