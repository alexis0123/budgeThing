package com.budgething.ui.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment

@Composable
fun SearchableDropDown(viewModel: ConfirmExpenseViewModel = viewModel()) {
    val query by viewModel.query.collectAsState()
    val filteredOptions by viewModel.filteredOptions.collectAsState()
    var showFilter by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = {
                viewModel.changeQuery(it)
                viewModel.clearSubCategory()
                viewModel.clearMainCategory()
                showFilter = it.isNotEmpty()
            },
            singleLine = true,
            placeholder = { Text("Expense name", color = MaterialTheme.colorScheme.onSecondary) },
            modifier = Modifier.fillMaxWidth()
        )

        if (showFilter) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 200.dp)
                    .padding(top = 55.dp)
            ) {
                items(filteredOptions) { item ->
                    Box(
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.surface)
                    ) {
                        Text(
                            text = item.name,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    viewModel.changeQuery(item.name)
                                    viewModel.setMainCategoryTo(item.mainCategory)
                                    viewModel.setSubCategoryTo(item.subCategory)
                                    viewModel.setDone()
                                    showFilter = false
                                    focusManager.clearFocus()
                                }
                                .padding(12.dp)
                        )
                    }
                }
            }
        }
    }
}

