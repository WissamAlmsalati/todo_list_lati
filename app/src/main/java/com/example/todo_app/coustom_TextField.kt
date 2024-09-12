// File: app/src/main/java/com/example/todo_app/CustomComponent.kt

package com.example.todo_app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    text: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    hint: String,
    containerColor: Color,
    focusedIndecatorColor: Color,
    unfocusedColor: Color,
    shape: RoundedCornerShape,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        TextField(
            maxLines = 1,
            value = text,
            onValueChange = onValueChange,
            placeholder = { Text(hint) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = containerColor,
                focusedIndicatorColor = focusedIndecatorColor,
                unfocusedIndicatorColor = unfocusedColor,
                cursorColor = Color(0xFF6200EE)
            ),
            shape = shape,
            modifier = Modifier
                .width(375.dp)
                .height(52.dp)
        )
    }
}