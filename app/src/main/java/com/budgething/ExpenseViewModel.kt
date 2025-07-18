package com.budgething

import androidx.lifecycle.ViewModel
import com.budgething.model.Expense
import com.budgething.repository.ExpenseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate

class ExpenseViewModel(): ViewModel() {

    private val repo = ExpenseRepository()
    private val _expenses = MutableStateFlow<List<Expense>>(emptyList())
    val expenses: StateFlow<List<Expense>> = _expenses

    fun loadExpenses() {
        _expenses.value = repo.getAllExpense()
    }

    fun addExpense(
        mainCategory: String,
        subCategory: String,
        name: String,
        amount: Double
    ) {
        repo.addExpense(Expense(
            mainCategory,
            subCategory,
            name,
            amount,
            LocalDate.now()
        ))
        loadExpenses()
    }

}