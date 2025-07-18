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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import java.util.Locale

@Composable
fun ConfirmExpenseDialog(
    showDialog: Boolean,
    amount: String,
    dismiss: () -> Unit,
    viewModel: ConfirmExpenseViewModel
) {

    val mainCategory = viewModel.mainCategory.collectAsState()
    val subCategory = viewModel.subCategory.collectAsState()

    val elevatedColor = MaterialTheme.colorScheme.surfaceColorAtElevation(200.dp)

    if (showDialog) {
        Dialog(
            onDismissRequest = {
                dismiss()
                viewModel.clearAllState()
                viewModel.setDone()
            }
        ) {
            Box(
                modifier = Modifier
                    .width(350.dp)
                    .height(400.dp)
                    .padding(10.dp)
                    .background(color = elevatedColor, shape = RoundedCornerShape(10.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp)
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                    text = String.format(Locale.US,"P %,.2f", amount.toDouble()),
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSurface
                    )
                    // Main Category Dropdown
                    Dropdown(
                        itemsList = viewModel.getMainCategories(),
                        selectedItem = mainCategory.value,
                        label = "Main Category",
                        onSelect = {
                            viewModel.setMainCategoryTo(it)
                            viewModel.clearSubCategory()
                        },
                        onRemove = {
                            viewModel.clearMainCategory()
                            viewModel.clearSubCategory()
                        }
                    )

                    // Sub Category Dropdown
                    Dropdown(
                        itemsList = viewModel.getSubCategories(mainCategory.value),
                        selectedItem = subCategory.value,
                        label = "Sub Category",
                        onSelect = {
                            viewModel.setSubCategoryTo(it)
                            viewModel.fillMainCategory()
                        },
                        onRemove = {
                            viewModel.clearSubCategory()
                        }
                    )

                    SearchableDropDown()

                }
            }
        }
    }
}