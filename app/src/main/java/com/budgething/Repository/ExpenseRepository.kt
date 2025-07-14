package com.budgething.Repository

import com.budgething.Model.Expense

class ExpenseRepository {

    val _expenses: MutableList<Expense> = mutableListOf()
    val expenses: List<Expense> get() = _expenses

    fun addExpense(expense: Expense) {
        _expenses.add(expense)
    }

}