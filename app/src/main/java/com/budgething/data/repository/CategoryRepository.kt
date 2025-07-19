package com.budgething.data.repository

import com.budgething.data.model.Category

class CategoryRepository {

    private val _categories = mutableListOf<Category>(
        Category(
            "Food", mutableListOf(
                "Meal",
                "Snacks",
                "Drinks",
                "Fruits",
                "Vegetables",
                "Instant Food"
            )
        ),

        Category(
            "Transportation", mutableListOf(
                "School Transportation",
                "General Transportation"
            )
        ),

        Category(
            "School", mutableListOf(
                "School Supplies",
                "School Fees",
                "Uniforms"
            )
        ),

        Category(
            "Health", mutableListOf(
                "Vitamins",
                "Medicines",
                "First Aid"
            )
        ),

        Category(
            "Cosmetics", mutableListOf(
                "Skincare",
                "Makeup",
                "Powder",
                "Cosmetic Tools"
            )
        ),

        Category(
            "Household", mutableListOf(
                "Cleaning Supplies",
                "Laundry Products",
                "Disinfectants",
                "Kitchen Supplies",
                "Dishwashing Soap",
                "Furniture",
                "Home Repair Tools",
                "Bedding",
                "Curtains",
                "Home Decor",
                "Appliances",
                "Toiletries",
                "Floss"
            )
        ),

        Category(
            "Electronics", mutableListOf(
                "Gadgets",
                "Tech Accessories"
            )
        ),

        Category(
            "Utilities", mutableListOf(
                "Electricity",
                "Water",
                "Gas",
                "Internet"
            )
        ),

        Category(
            "Others", mutableListOf(
                "Pet Food",
                "Service Fees"
            )
        )
    )

    val categories: List<Category> get() = _categories

    fun getMainCategoryFor(subcategory: String): String? {
        return _categories.firstOrNull { it.subcategories.contains(subcategory) }?.name
    }

    fun getSubCategories(mainCategory: String): List<String> {
        return _categories
            .firstOrNull { it.name == mainCategory }
            ?.subcategories
            ?:_categories.flatMap { it.subcategories }
    }

    fun addSubCategory(mainCategory: String, subcategory: String): Boolean {
        val category = _categories.firstOrNull() { it.name == mainCategory } ?: return false
        if (subcategory in category.subcategories) return false
        category.subcategories.add(subcategory)
        return true
    }

    fun getMainCategories(): List<String> {
        return _categories.map { it.name }
    }

}