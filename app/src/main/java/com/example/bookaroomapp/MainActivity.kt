package com.example.bookaroomapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookaroomapp.ui.screen.RoomCatalogScreen
import com.example.bookaroomapp.ui.theme.BookaRoomAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookaRoomAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RoomCatalogScreen(
                        modifier = Modifier.padding(innerPadding)
                    )

//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookaRoomAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            RoomCatalogScreen(
                modifier = Modifier.padding(innerPadding)
            )

        }
    }
}