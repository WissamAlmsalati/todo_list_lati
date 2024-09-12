// File: app/src/main/java/com/example/todo_app/LoginActivity.kt

package com.example.todo_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo_app.ui.theme.Todo_appTheme
// Ensure the correct import statement is present at the top of the file

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Todo_appTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "User",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val backgroundColor = Color(0xFFF5F6F8)
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(100.dp))
        Image(
            painter = painterResource(R.drawable.appicon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(230.dp))

        CustomTextField(
            text = textState.value,
            onValueChange = { textState.value = it },
            hint = "Email",
            containerColor = Color.White,
            focusedIndecatorColor = Color.White,
            unfocusedColor = Color.White,
            shape = RoundedCornerShape(10.dp),
        )
        CustomTextField(
            text = textState.value,
            onValueChange = { textState.value = it },
            hint = "Password",
            containerColor = Color.White,
            focusedIndecatorColor = Color.White,
            unfocusedColor = Color.White,
            shape = RoundedCornerShape(10.dp),
        )
        CustomButton(
            text = "Login",
            onClick = { /*TODO*/ },
            containerColor = Color(0xFFF79E89),
            textColor = Color.White,
            paddingSize = 16.0,
            height = 50,
            width = 375,
        )

       Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
) {
    Text(
        text = "Don't have an account?",
        modifier = Modifier.padding(end = 1.dp)
    )
    TextButton(
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color(0xFFF79E89) // Desired text color
        ),
        onClick = {
            context.startActivity(Intent(context, SignUpActivity::class.java))
        }
    ) {
        Text(
            text = "Sign Up",
            fontSize = 16.sp

        )
    }
}
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Todo_appTheme {
        Greeting("Android")
    }
}