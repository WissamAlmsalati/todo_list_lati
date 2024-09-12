// File: app/src/main/java/com/example/todo_app/CustomButton.kt

package com.example.todo_app

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.RectangleShape

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    containerColor: Color,
    textColor: Color,
    paddingSize: Double,
    height: Int,
    width: Int,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = containerColor),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .padding(paddingSize.dp)
            .height(height.dp)
            .width(width.dp)
    ) {
        Text(text = text, color = textColor)
    }
}