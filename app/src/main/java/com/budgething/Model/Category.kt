package com.budgething.Model

data class Category(
    val name: String,
    val subcategories: MutableList<String>
)
