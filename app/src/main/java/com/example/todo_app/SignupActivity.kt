// File: app/src/main/java/com/example/todo_app/SignUpActivity.kt

package com.example.todo_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo_app.ui.theme.Todo_appTheme
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusProperties

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Todo_appTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    val backgroundColor = Color(0xFFF5F6F8)
    val emailTextState = remember { mutableStateOf(TextFieldValue("")) }
    val passwordTextState = remember { mutableStateOf(TextFieldValue("")) }
    val userNameTextState = remember { mutableStateOf(TextFieldValue("")) }
    val scrollState = rememberScrollState()
    val focusRequester = FocusRequester()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(scrollState)
            .padding(16.dp)
            .imePadding() // This ensures that the screen content adjusts to the keyboard height
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.imeNestedScroll() // Enables smooth scrolling with nested scroll behavior
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                painter = painterResource(R.drawable.appicon),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(150.dp))

            CustomTextField(
                text = userNameTextState.value,
                onValueChange = { userNameTextState.value = it },
                hint = "UserName",
                containerColor = Color.White,
                focusedIndecatorColor = Color.White,
                unfocusedColor = Color.White,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.focusRequester(focusRequester)
            )
            CustomTextField(
                text = emailTextState.value,
                onValueChange = { emailTextState.value = it },
                hint = "Email",
                containerColor = Color.White,
                focusedIndecatorColor = Color.White,
                unfocusedColor = Color.White,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.focusRequester(focusRequester)
            )
            CustomTextField(
                text = passwordTextState.value,
                onValueChange = { passwordTextState.value = it },
                hint = "Password",
                containerColor = Color.White,
                focusedIndecatorColor = Color.White,
                unfocusedColor = Color.White,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.focusRequester(focusRequester)
            )
            CustomButton(
                text = "Sign Up",
                onClick = { /*TODO*/ },
                containerColor = Color(0xFFF79E89),
                textColor = Color.White,
                paddingSize = 16.0,
                height = 50,
                width = 375,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    Todo_appTheme {
        SignUpScreen()
    }
}