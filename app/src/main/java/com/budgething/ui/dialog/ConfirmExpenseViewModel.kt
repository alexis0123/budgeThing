package com.budgething.ui.dialog

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.budgething.Repository.CategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ConfirmExpenseViewModel: ViewModel() {

    val categoryRepo = CategoryRepository()

    private val _mainCategory = MutableStateFlow("")
    private val _subCategory = MutableStateFlow("")
    private val _query = MutableStateFlow("")

    val mainCategory: StateFlow<String> get() = _mainCategory
    val subCategory: StateFlow<String> get() = _subCategory
    val query: StateFlow<String> get() = _query

    fun getMainCategories(): List<String> {
        return categoryRepo.getMainCategories()
    }

    fun getSubCategories(mainCategory: String): List<String> {
        return categoryRepo.getSubCategories(mainCategory)
    }

    fun setMainCategoryTo(category: String) {
        _mainCategory.value = category
    }

    fun setSubCategoryTo(category: String) {
        _subCategory.value = category
    }

    fun clearMainCategory() {
        _mainCategory.value = ""
    }

    fun clearSubCategory() {
        _subCategory.value = ""
    }

    fun fillMainCategory() {
        _mainCategory.value = categoryRepo
            .getMainCategoryFor(_subCategory.value) ?: ""
    }

}