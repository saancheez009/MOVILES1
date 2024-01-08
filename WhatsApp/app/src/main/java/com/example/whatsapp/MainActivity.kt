
package com.example.whatsapp

import Login
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsapp.ui.theme.WhatsAppTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
//import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController= rememberNavController()
                    NavHost(navController = navController, startDestination = "home"){
                        composable(route="home"){
                            Login(){
                                navController.navigate("detail")
                            }
                        }
                        composable("detail"){
                            ChatScreen()

                        }
                    }

                }
            }
        }
    }
}



@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen() {
    var messageText by remember { mutableStateOf("") }
    var chatMessages by remember { mutableStateOf(listOf("Hello!", "Hi there!")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Chat messages
        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color.Gray.copy(alpha = 0.1f))
                .padding(16.dp)
        ) {
            chatMessages.forEach { message ->
                Text(text = message, modifier = Modifier.padding(8.dp))
            }
        }

        // Compose message input
        var keyboardController = LocalSoftwareKeyboardController.current
        OutlinedTextField(
            value = messageText,
            onValueChange = { messageText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    if (messageText.isNotEmpty()) {
                        chatMessages = chatMessages + messageText
                        messageText = ""
                        keyboardController?.hide()
                    }
                }
            ),
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (messageText.isNotEmpty()) {
                            chatMessages = chatMessages + messageText
                            messageText = ""
                            keyboardController?.hide()
                        }
                    }
                ) {
                    Icon(imageVector = Icons.Default.Send, contentDescription = "Send")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChatScreen() {
    WhatsAppTheme {
        ChatScreen()
    }
}