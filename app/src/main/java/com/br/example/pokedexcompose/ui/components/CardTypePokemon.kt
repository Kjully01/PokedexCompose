package com.br.example.pokedexcompose.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.br.example.pokedexcompose.ui.theme.WhiteWithTransparency

@Composable
fun CardTypePokemon(text: String, fontSize: TextUnit, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(100),
        colors = CardDefaults.cardColors(WhiteWithTransparency),
        border = BorderStroke(width = 0.5.dp, color = Color.White)
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            modifier = modifier,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Preview
@Composable
private fun CardTypePokemonPreview() {
    CardTypePokemon(
        text = "Poison",
        fontSize = 16.sp,
        modifier = Modifier.padding(vertical = 6.dp, horizontal = 11.dp)
    )
}