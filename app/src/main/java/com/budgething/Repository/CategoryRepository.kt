package com.budgething.Repository

import com.budgething.Model.Category

class CategoryRepository {

    private val _categories = mutableListOf<Category>(
        Category("Food",mutableListOf(
            "Groceries",
            "Snacks",
            "Drinks",
            "Fast Food",
            "Street Food",
            "Desserts",
            "Fruits",
            "Vegetables",
            "Meat & Poultry",
            "Seafood",
            "Dairy Products",
            "Baking Supplies",
            "Instant Food"
        )),

        Category("Transportation",mutableListOf(
            "School Transportation",
            "General Transportation"
        )),

        Category("School",mutableListOf(
            "School Supplies",
            "School Fees",
            "Uniforms"
        )),

        Category("Health",mutableListOf(
            "Vitamins",
            "Medicines",
            "First Aid"
        )),

        Category("Cosmetics",mutableListOf(
            "Skincare",
            "Makeup",
            "Lipstick",
            "Foundation",
            "Concealer",
            "Powder",
            "Eyeliner",
            "Mascara",
            "Eyeshadow",
            "Blush",
            "Highlighter",
            "Primer",
            "Setting Spray",
            "Facial Cleanser",
            "Toner",
            "Moisturizer",
            "Serums",
            "Sunscreen",
            "Face Masks",
            "Cosmetic Tools"
        )),

        Category("Household",mutableListOf(
            "Cleaning Supplies",
            "Laundry Products",
            "Toilet Paper",
            "Paper Towels",
            "Trash Bags",
            "Air Fresheners",
            "Disinfectants",
            "Kitchen Supplies",
            "Detergents",
            "Dishwashing Soap",
            "Light Bulbs",
            "Batteries",
            "Pest Control",
            "Storage Solutions",
            "Furniture",
            "Home Repair Tools",
            "Bedding",
            "Curtains",
            "Home Decor",
            "Appliances",
            "Toiletries",
            "Floss"
        )),

        Category("Electronics",mutableListOf(
            "Gadgets",
            "Tech Accessories"
        )),

        Category("Utilities",mutableListOf(
            "Electricity",
            "Water",
            "Gas",
            "Internet"
        )),

        Category("Others", mutableListOf(
            "Pet Food",
            "Service Fees"
        ))
    )

    val categories: List<Category> get() = _categories

    fun getSubCategoriesFor(mainCategory: String): List<String> {
        return _categories
            .firstOrNull { it.name == mainCategory }
            ?.subcategories
            ?:_categories.flatMap { it.subcategories }
    }

    fun getMainCategoryFor(subcategory: String): String? {
        return _categories.firstOrNull { it.subcategories.contains(subcategory) }?.name
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