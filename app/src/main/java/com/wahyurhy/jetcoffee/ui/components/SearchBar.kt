package com.wahyurhy.jetcoffee.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wahyurhy.jetcoffee.ui.theme.JetCoffeeTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
) {
    TextField(value = "", onValueChange = {}, modifier = modifier.padding(16.dp))
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    JetCoffeeTheme {
        SearchBar()
    }
}