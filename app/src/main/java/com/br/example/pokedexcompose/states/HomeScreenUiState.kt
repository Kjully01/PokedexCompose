package com.br.example.pokedexcompose.states

data class HomeScreenUiState (
    val text: String = "",
    val onSearchChange: (String) -> Unit = {}
)