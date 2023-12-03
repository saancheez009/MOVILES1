package com.example.imagenessonidos

import android.content.DialogInterface
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.imagenessonidos.ui.theme.ImagenesSonidosTheme
class MainActivity : ComponentActivity(), DialogInterface.OnClickListener {
    private var mediaplayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImagenesSonidosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Call your Composable functions here
                    MainContent()
                }
            }
        }
        mediaplayer = MediaPlayer.create(this, R.raw.gato)
    }

    @Composable
    fun MainContent() {
        var mediaPlayer by remember { mutableStateOf(mediaplayer) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimalButton(R.raw.gatico, "Gato") {
                mediaPlayer?.release()
                mediaPlayer = MediaPlayer.create(LocalContext.current, it)
                mediaPlayer?.start()
            }
            AnimalButton(R.raw.perro, "Perro") {
                mediaPlayer?.release()
                mediaPlayer = MediaPlayer.create(LocalContext.current, it)
                mediaPlayer?.start()
            }
            AnimalButton(R.raw.cerdo, "Cerdo") {
                mediaPlayer?.release()
                mediaPlayer = MediaPlayer.create(LocalContext.current, it)
                mediaPlayer?.start()
            }
        }
    }

    @Composable
    fun AnimalButton(rawResId: Int, text: String, onClick: (Int) -> Unit) {
        val resourceId = painterResource(id = rawResId)

        Row(
            modifier = Modifier
                .padding(8.dp)
                .clickable { onClick(rawResId) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = resourceId,
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = text,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.subtitle1
            )
        }
    }

    override fun onClick(v: View) {
        // Handle click events if needed
    }
}



 /*{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImagenesSonidosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImagenesSonidosTheme {
        Greeting("Android")
    }
}*/