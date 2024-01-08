import android.content.Context
import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun Login(onButtonClick: () -> Unit) {
    var phoneNumber by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
                isError = false
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            label = { Text(text = "Phone Number") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            ),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Phone, contentDescription = null)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {onButtonClick()},
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            if (isLoading) {
                CircularProgressIndicator(color = Color.White)
            } else {
                Icon(imageVector = Icons.Default.Send, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Log In")
            }
        }

        if (isError) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}



@Composable
fun showToast(context: Context, message: String) {
    val density = LocalDensity.current.density
    val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, (64 * density).toInt())
    toast.show()
}