package com.br.example.pokedexcompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.br.example.pokedexcompose.ui.theme.GrayLabelSearchFocused
import com.br.example.pokedexcompose.ui.theme.GrayLabelSearchUnfocused
import com.br.example.pokedexcompose.ui.theme.GraySearchFocused
import com.br.example.pokedexcompose.ui.theme.GraySearchUnfocused

@Composable
fun SearchTextField(text: String, onSearchChange: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = { newValue ->
            onSearchChange(newValue)
        },
        shape = RoundedCornerShape(20),
        label = {
            Text(text = "Search Pokemon")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = GraySearchUnfocused,
            focusedContainerColor = GraySearchFocused,
            unfocusedLabelColor = GrayLabelSearchUnfocused,
            focusedLabelColor = GrayLabelSearchFocused,
            unfocusedLeadingIconColor = GrayLabelSearchUnfocused,
            focusedLeadingIconColor = GrayLabelSearchFocused,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .padding(bottom = 24.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
    )
}