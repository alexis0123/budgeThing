package com.budgething.ui.dialog

import androidx.lifecycle.ViewModel
import com.budgething.model.Item
import com.budgething.repository.CategoryRepository
import com.budgething.repository.ItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ConfirmExpenseViewModel: ViewModel() {

    val categoryRepo = CategoryRepository()
    val itemRepo = ItemRepository()

    private val _filteredOptions = MutableStateFlow<List<Item>>(emptyList())
    private val _mainCategory = MutableStateFlow("")
    private val _subCategory = MutableStateFlow("")
    private val _query = MutableStateFlow("")
    private val _done = MutableStateFlow(false)

    val filteredOptions: StateFlow<List<Item>> get() = _filteredOptions
    val mainCategory: StateFlow<String> get() = _mainCategory
    val subCategory: StateFlow<String> get() = _subCategory
    val query: StateFlow<String> get() = _query
    val done: StateFlow<Boolean> get() = _done
    val allItems = itemRepo.getItems()

    fun getMainCategories(): List<String> {
        return categoryRepo.getMainCategories()
    }

    fun setMainCategoryTo(category: String) {
        _mainCategory.value = category
    }

    fun clearMainCategory() {
        _mainCategory.value = ""
    }

    fun fillMainCategory() {
        _mainCategory.value = categoryRepo
            .getMainCategoryFor(_subCategory.value) ?: ""
    }

    fun getSubCategories(mainCategory: String): List<String> {
        return categoryRepo.getSubCategories(mainCategory)
    }

    fun setSubCategoryTo(category: String) {
        _subCategory.value = category
    }

    fun changeQuery(query: String) {
        _query.value = query
        _filteredOptions.value = if (query.isEmpty()) {
            emptyList()
        } else {
            allItems.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }
    }

    fun clearQuery() {
        _query.value = ""
    }

    fun clearSubCategory() {
        _subCategory.value = ""
    }

    fun clearAllState() {
        clearSubCategory()
        clearMainCategory()
        clearQuery()
    }

    fun setDone() {
        _done.value = true
    }

    fun setUnDone() {
        _done.value = false
    }

}