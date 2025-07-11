package com.budgething.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GreetingsViewModel: ViewModel() {

    var name by mutableStateOf("")

    fun submitName(newName:String = "") {
        name = newName.replaceFirstChar { it.uppercase() }
    }
}