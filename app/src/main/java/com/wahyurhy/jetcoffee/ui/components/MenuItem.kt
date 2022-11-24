package com.wahyurhy.jetcoffee.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wahyurhy.jetcoffee.R
import com.wahyurhy.jetcoffee.model.Menu

@Composable
fun MenuItem(
    menu: Menu,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.width(140.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.clickable(onClick = {})
        ) {
            Image(
                painter = painterResource(id = menu.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = menu.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.ExtraBold),
                )
                Text(
                    text = menu.price,
                    style = MaterialTheme.typography.subtitle2,
                )
            }
        }
    }
}

@Preview
@Composable
fun MenuItemPreview() {
    MaterialTheme {
        MenuItem(menu = Menu(R.drawable.menu1, "Tiramisu Coffee Milk", "Rp 28.000"), modifier = Modifier.padding(8.dp))
    }
}