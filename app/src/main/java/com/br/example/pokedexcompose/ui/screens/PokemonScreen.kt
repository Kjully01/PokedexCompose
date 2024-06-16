package com.br.example.pokedexcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.br.example.pokedexcompose.R
import com.br.example.pokedexcompose.ui.components.CardTypePokemon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text(text = "") },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        Modifier.size(24.dp),
                        tint = Color.White
                    )
                }
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Pokemons Favorites",
                        Modifier.size(24.dp),
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(Color.Transparent)
        )
        Image(
            modifier = Modifier.size(260.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )
        Text(
            text = "Bulbassaur",
            fontSize = 36.sp,
            modifier = Modifier.padding(top = 24.dp),
            color = Color.White
        )
        Row(
            Modifier.padding(top = 8.dp, bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CardTypePokemon(
                text = "Grass",
                fontSize = 18.sp,
                Modifier.padding(vertical = 6.dp, horizontal = 11.dp)
            )
            CardTypePokemon(
                text = "Posion",
                fontSize = 18.sp,
                Modifier.padding(vertical = 6.dp, horizontal = 11.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PokemonScreenPreview() {
    PokemonScreen()
}