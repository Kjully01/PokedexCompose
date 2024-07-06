package com.br.example.pokedexcompose.data_remote.model

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("results")
    val pokemonList: List<PokemonResponse>
)

