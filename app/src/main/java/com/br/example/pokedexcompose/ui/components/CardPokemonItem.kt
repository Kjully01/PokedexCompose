package com.br.example.pokedexcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.br.example.pokedexcompose.R
import com.br.example.pokedexcompose.model.Pokemon

@Composable
fun CardPokemonItem(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(85.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray,
        )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, end = 12.dp, start = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "#001", fontSize = 10.sp, color = Color.White)
                Text(text = pokemon.name, fontSize = 16.sp, color = Color.White)
                Row(
                    Modifier.padding(top = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    CardTypePokemon(
                        text = "Grass",
                        fontSize = 10.sp,
                        Modifier.padding(vertical = 4.dp, horizontal = 10.dp)
                    )
                    CardTypePokemon(
                        text = "Posion",
                        fontSize = 10.sp,
                        Modifier.padding(vertical = 4.dp, horizontal = 10.dp)
                    )
                }
            }
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .padding(end = 8.dp)
                        .size(60.dp)

                )
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    Modifier
                        .size(16.dp),
                    tint = Color.White
                )
            }
        }

    }
}

@Preview
@Composable
private fun CardPokemonItemPreview() {
    CardPokemonItem(Pokemon(1, "Bulbassaur", listOf("Grass", "Possion")))
}