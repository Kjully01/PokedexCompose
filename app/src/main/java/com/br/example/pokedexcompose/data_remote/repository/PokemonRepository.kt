package com.br.example.pokedexcompose.data_remote.repository

import com.br.example.pokedexcompose.data_remote.api.ApiBuilder
import com.br.example.pokedexcompose.data_remote.model.PokemonListResponse
import com.br.example.pokedexcompose.data_remote.model.PokemonResponse
import com.br.example.pokedexcompose.model.Pokemon
import com.br.example.pokedexcompose.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class PokemonRepository {

    companion object {
        private val pokemons = MutableStateFlow<List<Pokemon>>(emptyList())
    }

    fun getPokemons(): StateFlow<List<Pokemon>> = pokemons.asStateFlow()

}