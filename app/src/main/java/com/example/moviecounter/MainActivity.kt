package com.example.moviecounter

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviecounter.ui.theme.MovieCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieCounterTheme {
                // LLAMADA CORRECTA A MovieCounter
                MovieCounter()
            }
        }
    }
}

@Composable
fun MovieCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    var movieName by remember { mutableStateOf("") }  // Estado para el nombre

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have added $count movies.")
        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para ingresar nombre
        TextField(
            value = movieName,
            onValueChange = { movieName = it },
            label = { Text("Movie Name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (movieName.isNotBlank()) {
                count++
                movieName = ""  // Limpia el campo
            }
        }) {
            Text("Add Movie")
        }
    }
}
// PREVIEW CORRECTO
@Preview(showBackground = true)
@Composable
fun PreviewMovieCounter() {
    MovieCounterTheme {
        MovieCounter()
    }
}