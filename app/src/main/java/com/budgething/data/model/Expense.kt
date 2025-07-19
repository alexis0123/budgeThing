package com.budgething.data.model

import java.time.LocalDate

data class Expense(
    val category: String,
    val subcategory: String,
    val name: String,
    val amount: Double,
    val date: LocalDate
)