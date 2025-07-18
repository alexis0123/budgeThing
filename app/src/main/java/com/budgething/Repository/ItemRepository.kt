package com.budgething.Repository

import com.budgething.Model.Item

class ItemRepository {

    private val items = listOf(
        // === FOOD ===
        Item("Meal", "Food", "Meal"),
        Item("Jollibee Chickenjoy", "Food", "Meal"),
        Item("Mang Inasal PM1", "Food", "Meal"),
        Item("Tapsilog", "Food", "Meal"),
        Item("Longsilog", "Food", "Meal"),
        Item("Bangsilog", "Food", "Meal"),
        Item("Adobo", "Food", "Meal"),
        Item("Sinigang", "Food", "Meal"),
        Item("Lechon Kawali", "Food", "Meal"),
        Item("Rice", "Food", "Meal"),

        Item("Snacks", "Food", "Snacks"),
        Item("Skyflakes", "Food", "Snacks"),
        Item("Piattos", "Food", "Snacks"),
        Item("Nova", "Food", "Snacks"),
        Item("Chippy", "Food", "Snacks"),
        Item("Banana Cue", "Food", "Snacks"),
        Item("Turon", "Food", "Snacks"),
        Item("Kornik", "Food", "Snacks"),
        Item("Pandesal", "Food", "Snacks"),

        Item("Drinks", "Food", "Drinks"),
        Item("Coke", "Food", "Drinks"),
        Item("Royal Tru-Orange", "Food", "Drinks"),
        Item("Iced Tea", "Food", "Drinks"),
        Item("Taho", "Food", "Drinks"),
        Item("Sago't Gulaman", "Food", "Drinks"),
        Item("Buko Juice", "Food", "Drinks"),

        Item("Fruits", "Food", "Fruits"),
        Item("Apple", "Food", "Fruits"),
        Item("Banana", "Food", "Fruits"),
        Item("Mango", "Food", "Fruits"),
        Item("Papaya", "Food", "Fruits"),
        Item("Lanzones", "Food", "Fruits"),
        Item("Mangosteen", "Food", "Fruits"),

        Item("Vegetables", "Food", "Vegetables"),
        Item("Kangkong", "Food", "Vegetables"),
        Item("Sitaw", "Food", "Vegetables"),
        Item("Ampalaya", "Food", "Vegetables"),
        Item("Kalabasa", "Food", "Vegetables"),
        Item("Talong", "Food", "Vegetables"),

        Item("Instant Food", "Food", "Instant Food"),
        Item("Pancit Canton", "Food", "Instant Food"),
        Item("Lucky Me Noodles", "Food", "Instant Food"),
        Item("Cup Noodles", "Food", "Instant Food"),
        Item("Quick Chow", "Food", "Instant Food"),

        Item("Street Food", "Food", "Street Food"),
        Item("Fishball", "Food", "Street Food"),
        Item("Kwek-Kwek", "Food", "Street Food"),
        Item("Isaw", "Food", "Street Food"),
        Item("Tokneneng", "Food", "Street Food"),
        Item("Betamax", "Food", "Street Food"),
        Item("Adidas (Chicken Feet)", "Food", "Street Food"),

        Item("Ice Cream", "Food", "Ice Cream"),
        Item("Magnolia Ice Cream", "Food", "Ice Cream"),
        Item("Cornetto", "Food", "Ice Cream"),
        Item("Dirty Ice Cream", "Food", "Ice Cream"),
        Item("Halo-Halo", "Food", "Ice Cream"),
        Item("Mais Con Yelo", "Food", "Ice Cream"),

        // === TRANSPORTATION ===
        Item("School Transportation", "Transportation", "School Transportation"),
        Item("Jeepney Fare", "Transportation", "School Transportation"),
        Item("Bus Fare", "Transportation", "General Transportation"),
        Item("Tricycle Fare", "Transportation", "General Transportation"),
        Item("GrabCar", "Transportation", "General Transportation"),

        // === SCHOOL ===
        Item("School Supplies", "School", "School Supplies"),
        Item("Notebook", "School", "School Supplies"),
        Item("Ballpen", "School", "School Supplies"),
        Item("School Fees", "School", "School Fees"),
        Item("Tuition", "School", "School Fees"),
        Item("Uniforms", "School", "Uniforms"),
        Item("PE Uniform", "School", "Uniforms"),

        // === HEALTH ===
        Item("Vitamins", "Health", "Vitamins"),
        Item("Ascorbic Acid", "Health", "Vitamins"),
        Item("Medicines", "Health", "Medicines"),
        Item("Paracetamol", "Health", "Medicines"),
        Item("First Aid", "Health", "First Aid"),
        Item("Band-Aid", "Health", "First Aid"),

        // === COSMETICS ===
        Item("Skincare", "Cosmetics", "Skincare"),
        Item("Facial Cleanser", "Cosmetics", "Skincare"),
        Item("Makeup", "Cosmetics", "Makeup"),
        Item("Lipstick", "Cosmetics", "Makeup"),
        Item("Powder", "Cosmetics", "Powder"),
        Item("Baby Powder", "Cosmetics", "Powder"),
        Item("Cosmetic Tools", "Cosmetics", "Cosmetic Tools"),
        Item("Makeup Brush", "Cosmetics", "Cosmetic Tools"),

        // === HOUSEHOLD ===
        Item("Cleaning Supplies", "Household", "Cleaning Supplies"),
        Item("Laundry Products", "Household", "Laundry Products"),
        Item("Dishwashing Soap", "Household", "Dishwashing Soap"),
        Item("Furniture", "Household", "Furniture"),
        Item("Home Repair Tools", "Household", "Home Repair Tools"),
        Item("Curtains", "Household", "Curtains"),
        Item("Appliances", "Household", "Appliances"),
        Item("Toiletries", "Household", "Toiletries"),
        Item("Floss", "Household", "Floss"),

        // === ELECTRONICS ===
        Item("Gadgets", "Electronics", "Gadgets"),
        Item("Smartphone", "Electronics", "Gadgets"),
        Item("Tech Accessories", "Electronics", "Tech Accessories"),
        Item("Earphones", "Electronics", "Tech Accessories"),

        // === UTILITIES ===
        Item("Electricity", "Utilities", "Electricity"),
        Item("Water", "Utilities", "Water"),
        Item("Gas", "Utilities", "Gas"),
        Item("Internet", "Utilities", "Internet"),

        // === OTHERS ===
        Item("Pet Food", "Others", "Pet Food"),
        Item("Service Fees", "Others", "Service Fees")
    )

    fun getItems(): List<Item> {
        return items
    }

}