package com.budgething.data.repository

import com.budgething.data.model.Expense

class ExpenseRepository {

    private val _expenses: MutableList<Expense> = mutableListOf()

    fun addExpense(expense: Expense) {
        _expenses.add(expense)
    }

    fun getAllExpense(): List<Expense> = _expenses

    fun clearAll() = _expenses.clear()

}