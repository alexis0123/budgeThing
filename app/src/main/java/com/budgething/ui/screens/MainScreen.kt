package com.budgething.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.budgething.viewmodel.NumKeyViewModel
import com.budgething.ui.theme.BudgeThingTheme
import com.budgething.ui.components.FormattedAmountDisplay
import com.budgething.ui.components.keypad.KeyPad
import com.budgething.ui.dialog.ConfirmExpenseDialog
import com.budgething.viewmodel.ConfirmExpenseViewModel

@Composable
fun MainScreen(viewModel: NumKeyViewModel = viewModel(),
               confirmExpenseViewModel: ConfirmExpenseViewModel = viewModel()
) {

    val amount by viewModel.amount.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    var mainCategory by remember { mutableStateOf("") }
    var subCategory by remember { mutableStateOf("") }

    ConfirmExpenseDialog(
        showDialog = showDialog,
        amount = amount,
        mainCategory = mainCategory,
        subCategory = subCategory,
        onMainCategoryChange = { mainCategory = it },
        onSubCategoryChange = { subCategory = it },
        dismiss = { showDialog = false },
        viewModel = confirmExpenseViewModel
    )

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
                    .weight(1.4f)
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                HorizontalDivider()

                KeyPad({
                    showDialog = true
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