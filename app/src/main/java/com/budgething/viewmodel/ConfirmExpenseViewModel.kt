package com.budgething.viewmodel

import androidx.lifecycle.ViewModel
import com.budgething.Model.Category
import com.budgething.Repository.CategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ConfirmExpenseViewModel: ViewModel() {

    private val _mainCategoryQuery = MutableStateFlow("")
    private val _subCategoryQuery = MutableStateFlow("")
    private val _isDropDownVisible = MutableStateFlow(false)
    val subCategoryQuery: StateFlow<String> get() = _subCategoryQuery
    val isDropDownVisible: StateFlow<Boolean> get() = _isDropDownVisible

    val categoryRepo = CategoryRepository()

    fun searchSubCategory(text: String) {
        _subCategoryQuery.value = text
    }

//    fun getFilteredOptions(): List<String> {
//        return categoryRepo.getSubCategoriesFor()
//            .filter { it.contains(_subCategoryQuery.value, ignoreCase = true) }
//    }

    fun getSubCategories(mainCategory: String): List<String> {
        return categoryRepo.getSubCategoriesFor(mainCategory)
    }

    fun getMainCategories(): List<String> {
        return categoryRepo.getMainCategories()
    }

}