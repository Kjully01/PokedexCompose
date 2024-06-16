package com.br.example.pokedexcompose

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
import com.br.example.pokedexcompose.model.Pokemon
import com.br.example.pokedexcompose.ui.screens.HomeScreen
import com.br.example.pokedexcompose.ui.theme.PokedexComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeScreen(
                pokemons = listOf(
                    Pokemon(1, "Bulbassaur", listOf("Grass", "Poison")),
                    Pokemon(2, "Bulbassaur", listOf("Grass", "Poison")),
                    Pokemon(3, "Bulbassaur", listOf("Grass", "Poison"))
                )
            )
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
    PokedexComposeTheme {
        Greeting("Android")
    }
}