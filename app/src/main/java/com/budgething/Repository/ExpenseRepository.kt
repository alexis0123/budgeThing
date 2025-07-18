package com.budgething.Repository

import com.budgething.Model.Expense

class ExpenseRepository {

    private val _expenses: MutableList<Expense> = mutableListOf()
    val expenses: List<Expense> get() = _expenses

    fun addExpense(expense: Expense) {
        _expenses.add(expense)
    }

}