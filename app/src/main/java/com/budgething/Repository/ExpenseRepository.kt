package com.budgething.Repository

import com.budgething.Model.Expense

class ExpenseRepository {

    val expenses: MutableList<Expense> = mutableListOf()

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }

    fun getAllExpenses(): MutableList<Expense> {
        return expenses
    }

}