package com.br.example.pokedexcompose.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.br.example.pokedexcompose.model.Pokemon
import com.br.example.pokedexcompose.states.HomeScreenUiState
import com.br.example.pokedexcompose.ui.components.CardPokemonItem
import com.br.example.pokedexcompose.ui.components.SearchTextField
import com.br.example.pokedexcompose.ui.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {
    val state by viewModel.uiState.collectAsState()
    HomeScreen(state = state)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    pokemons: List<Pokemon> = listOf(), //retirar
    navController: NavController = rememberNavController(), //retirar
    state: HomeScreenUiState = HomeScreenUiState()
) {
    val text = state.text
    Column {
        Card(
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            TopAppBar(
                title = {
                    Text(text = "Pokédex")
                },
                actions = {
                    IconButton(onClick = {
                    }) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Pokemons Favorites",
                            Modifier.size(24.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Transparent)
            )
            SearchTextField(text = text, onSearchChange = state.onSearchChange)
        }

        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(pokemons) { pokemon ->
                CardPokemonItem(
                    pokemon,
                    Modifier.clickable {
                        navController.navigate("pokemon")
                    })
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        pokemons = listOf(
            Pokemon(1, "Bulbassaur", listOf("Grass", "Poison")),
            Pokemon(2, "teste", listOf("Grass", "Poison")),
            Pokemon(3, "pokemon", listOf("Grass", "Poison"))
        ),
        navController = rememberNavController()
    )
}