package com.wahyurhy.jetcoffee.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wahyurhy.jetcoffee.ui.theme.JetCoffeeTheme

@Composable
fun SectionText(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.ExtraBold),
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Preview
@Composable
fun SectionTextPreview() {
    JetCoffeeTheme {
        SectionText(title = "Mau ngopi apa hari ini?")
    }
}