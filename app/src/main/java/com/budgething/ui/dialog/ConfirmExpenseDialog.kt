package com.budgething.ui.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.budgething.ui.dialog.ConfirmExpenseViewModel
import java.util.Locale

@Composable
fun ConfirmExpenseDialog(
    showDialog: Boolean,
    amount: String,
    mainCategory: String,
    subCategory: String,
    onMainCategoryChange: (String) -> Unit,
    onSubCategoryChange: (String) -> Unit,
    dismiss: () -> Unit,
    viewModel: ConfirmExpenseViewModel
) {
    val elevatedColor = MaterialTheme.colorScheme.surfaceColorAtElevation(200.dp)

    if (showDialog) {
        Dialog(onDismissRequest = dismiss) {
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .height(400.dp)
                    .padding(10.dp)
                    .background(color = elevatedColor, shape = RoundedCornerShape(10.dp))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Main Category Dropdown
                    Dropdown(
                        itemsList = viewModel.getMainCategories(),
                        selectedItem = mainCategory,
                        label = "Main Category",
                        onSelect = onMainCategoryChange
                    )

                    // Sub Category Dropdown
                    Dropdown(
                        itemsList = viewModel.getSubCategories(mainCategory),
                        selectedItem = subCategory,
                        label = "Sub Category",
                        onSelect = onSubCategoryChange
                    )

                    Text(
                        text = String.format(Locale.US,"P %,.2f", amount.toDouble()),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 20.sp)
                }
            }
        }
    }
}