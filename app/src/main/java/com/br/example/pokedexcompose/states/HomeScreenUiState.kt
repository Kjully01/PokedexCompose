package com.br.example.pokedexcompose.states

import com.br.example.pokedexcompose.model.Pokemon

data class HomeScreenUiState (
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {},
    val pokemons: List<Pokemon> = emptyList()
)