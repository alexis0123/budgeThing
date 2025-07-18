package com.budgething.model

import java.time.LocalDate

data class Expense(
    val category: String,
    val subcategory: String,
    val name: String,
    val amount: Double,
    val date: LocalDate
)