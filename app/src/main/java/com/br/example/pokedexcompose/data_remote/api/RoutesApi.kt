package com.br.example.pokedexcompose.data_remote.api

import com.br.example.pokedexcompose.data_remote.model.PokemonListResponse
import com.br.example.pokedexcompose.data_remote.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RoutesApi {
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int
    ): Response<PokemonListResponse>

    @GET("pokemon/{id}")
    suspend fun getPokemon(
        @Path("id") id: Int
    ): Response<PokemonResponse>
}