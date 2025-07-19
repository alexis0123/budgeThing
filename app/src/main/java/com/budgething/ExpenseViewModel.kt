package com.budgething

import androidx.lifecycle.ViewModel
import com.budgething.data.model.Expense
import com.budgething.data.repository.ExpenseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate

class ExpenseViewModel(): ViewModel() {

    private val repo = ExpenseRepository()
    private val _expenses = MutableStateFlow<List<Expense>>(emptyList())
    private val _total = MutableStateFlow(0.00)
    val expenses: StateFlow<List<Expense>> get() = _expenses
    val total: StateFlow<Double> get() = _total

    fun loadExpenses() {
        _expenses.value = repo.getAllExpense().toList()
    }

    fun getTotal() {
        _total.value = _expenses.value.sumOf { it.amount }
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
        getTotal()
    }

    fun clearAll() {
        repo.clearAll()
        loadExpenses()
        getTotal()
    }

}