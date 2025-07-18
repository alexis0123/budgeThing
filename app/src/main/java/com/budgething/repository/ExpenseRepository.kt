package com.budgething.repository

import com.budgething.model.Expense

class ExpenseRepository {

    private val _expenses: MutableList<Expense> = mutableListOf()

    fun addExpense(expense: Expense) {
        _expenses.add(expense)
    }

    fun getAllExpense(): List<Expense> = _expenses

}