package com.budgething.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SampleViewModel: ViewModel() {

    var num by mutableStateOf(0)
        private set

    fun incrementBy(n: Int = 1) {
        num += n
    }

    fun decrementBy(n: Int = 1) {
        num -= n
    }

    fun resetNum() {
        num = 0
    }

}