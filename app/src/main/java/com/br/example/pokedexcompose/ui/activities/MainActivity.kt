package com.br.example.pokedexcompose.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.br.example.pokedexcompose.model.Pokemon
import com.br.example.pokedexcompose.ui.screens.HomeScreen
import com.br.example.pokedexcompose.ui.screens.PokemonScreen
import com.br.example.pokedexcompose.ui.viewmodel.HomeScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val pokemons = listOf(
                Pokemon(1, "Bulbassaur", listOf("Grass", "Poison")),
                Pokemon(2, "teste", listOf("Grass", "Poison")),
                Pokemon(3, "pokemon", listOf("Grass", "Poison"))
            )
            val navController = rememberNavController()
            val viewModel by viewModels<HomeScreenViewModel>()
            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                composable("home") {
                    HomeScreen(
                        viewModel
//                        pokemons = pokemons, navController = navController
                    )
                }
                composable("pokemon") {
                    PokemonScreen(navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
//    PokedexComposeTheme { /*TODO veririficar depois*/
        Surface {
            HomeScreen(
                pokemons = listOf(
                    Pokemon(1, "Bulbassaur", listOf("Grass", "Poison")),
                    Pokemon(2, "teste", listOf("Grass", "Poison")),
                    Pokemon(3, "pokemon", listOf("Grass", "Poison"))
                ), navController = rememberNavController()
            )
        }
//    }
}