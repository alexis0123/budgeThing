package com.budgething.ui.components.keypad

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Key(
    label: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.width(80.dp).height(80.dp)
    ) { Text(label, fontSize = 25.sp) }
}

@Composable
fun Confirm(label: String, enabled: Boolean, onClick: () -> Unit) {

    Button(
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2E7D32)),
        modifier = Modifier.width(80.dp).height(80.dp)
    ) { Text(label, fontSize = 30.sp) }

}