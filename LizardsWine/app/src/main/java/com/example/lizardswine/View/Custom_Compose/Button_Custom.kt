package com.example.lizardswine.View.Custom_Compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonAccept_Cancel(
    onClickButton: () -> Unit,
    colorText_Border: Long,
    text: String
){
    Button(
        onClick = onClickButton,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE8F5E9)),//0xFFE8F5E9
        border = BorderStroke(1.dp, Color(colorText_Border)),//0xFF009688
    ) {
        Text(text = text, color = Color(colorText_Border))
    }
}