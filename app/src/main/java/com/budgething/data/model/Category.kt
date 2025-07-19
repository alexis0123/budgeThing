package com.budgething.data.model

data class Category(
    val name: String,
    val subcategories: MutableList<String>
)