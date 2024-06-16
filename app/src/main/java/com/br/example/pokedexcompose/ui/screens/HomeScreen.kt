package com.br.example.pokedexcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.br.example.pokedexcompose.model.Pokemon
import com.br.example.pokedexcompose.ui.components.CardPokemonItem
import com.br.example.pokedexcompose.ui.components.SearchTextField

@Composable
fun HomeScreen(pokemons: List<Pokemon>) {
    Column {
        SearchTextField()
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(pokemons) {
                CardPokemonItem()
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
            Pokemon(2, "Bulbassaur", listOf("Grass", "Poison")),
            Pokemon(3, "Bulbassaur", listOf("Grass", "Poison"))
        )
    )
}