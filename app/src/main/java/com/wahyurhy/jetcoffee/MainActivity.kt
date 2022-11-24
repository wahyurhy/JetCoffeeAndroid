package com.wahyurhy.jetcoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wahyurhy.jetcoffee.model.Menu
import com.wahyurhy.jetcoffee.model.dummyBestSellerMenu
import com.wahyurhy.jetcoffee.model.dummyCategory
import com.wahyurhy.jetcoffee.model.dummyMenu
import com.wahyurhy.jetcoffee.ui.components.*
import com.wahyurhy.jetcoffee.ui.theme.JetCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCoffeeTheme {
                JetCoffeeApp()
            }
        }
    }
}

@Composable
fun JetCoffeeApp() {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Banner()
            HomeSection(
                title = stringResource(id = R.string.section_category),
                content = { CategoryRow() }
            )
            HomeSection(
                title = stringResource(id = R.string.section_favorite_menu),
                content = { MenuRow(listMenu = dummyMenu) }
            )
            HomeSection(
                title = stringResource(id = R.string.section_best_seller_menu),
                content = { MenuRow(listMenu = dummyBestSellerMenu) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JetCoffeeAppPreview() {
    JetCoffeeTheme {
        JetCoffeeApp()
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        SearchBar()
    }
}

@Preview
@Composable
fun BannerPreview() {
    JetCoffeeTheme {
        Banner()
    }
}

@Composable
fun CategoryRow(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(category = category)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CategoryRowPreview() {
    JetCoffeeTheme {
        CategoryRow()
    }
}

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu = menu)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuRowPreview() {
    JetCoffeeTheme {
        MenuRow(dummyMenu)
    }
}