package com.br.example.pokedexcompose.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.example.pokedexcompose.data_remote.repository.PokemonRepository
import com.br.example.pokedexcompose.model.Pokemon
import com.br.example.pokedexcompose.states.HomeScreenUiState
import com.br.example.pokedexcompose.utils.mockPokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    private val repository = PokemonRepository()
    private val _uiState: MutableStateFlow<HomeScreenUiState> = MutableStateFlow(
        HomeScreenUiState()
    )
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onSearchChange = {
                    _uiState.value = _uiState.value.copy(
                        searchText = it,
                        pokemons = searchedPokemon(it)
                    )
                }
            )
        }

        viewModelScope.launch {
            repository.getPokemons().collect { pokemons ->
                _uiState.value = _uiState.value.copy(
                    pokemons = searchedPokemon(_uiState.value.searchText)
                )
            }
        }
    }

    private fun searchedPokemon(text: String): List<Pokemon> =
        if (text.isNotBlank()) {
            mockPokemon.filter(containsInName(text))
        } else mockPokemon

    private fun containsInName(text: String): (Pokemon) -> Boolean = {
        it.name.contains(
            text,
            ignoreCase = true
        )
    }

}