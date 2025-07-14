package com.budgething.Model

import java.time.LocalDateTime

data class Expense(
    val category: String,
    val subcategory: String,
    val amount: Double,
    val date: LocalDateTime
)