package com.budgething.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NumKeyViewModel: ViewModel() {

    private val _amount = MutableStateFlow("")
    val amount: StateFlow<String> get() = _amount

    fun addDigit(num: String) {
        _amount.value += num
    }

    fun deleteLast() {
        _amount.value = _amount.value.dropLast(1)
    }

    fun deleteAll() {
        _amount.value = ""
    }

}