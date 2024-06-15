package com.emilio.app01

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Preview(showSystemUi = true)
fun ListadoPreview(){
    Listado()
}

@Composable
fun Listado(){
    ConstraintLayout {

        val topGuideline = createGuidelineFromTop(0.1f)

        val bottomGuideline = createGuidelineFromBottom(0.1f)

        val (header,content,footer) = createRefs()
        Box(modifier = Modifier.fillMaxSize()){
            Row(modifier = Modifier.padding(10.dp)) {
                Icon(imageVector = Icons.Rounded.Menu,contentDescription = "icono", tint = Color.Black)

            }
        }

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Gray)
            .fillMaxSize()
            .constrainAs(header) {
                top.linkTo(topGuideline)


            }){

        }
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Gray)
            .fillMaxSize()
            .constrainAs(content) {
                top.linkTo(topGuideline)


            }){

        }
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Gray)
            .fillMaxSize()
            .constrainAs(footer) {
                top.linkTo(bottomGuideline)


            }){

        }


    }
}

/*

ConstraintLayout {
        val startGuideline = createGuidelineFromStart(0.1f)

        val (header,content,footer) = createRefs()

        Column(modifier= Modifier.constrainAs(header)) {
            Box(modifier = Modifier.background(Color.White)){
                Row(modifier = Modifier.padding(10.dp)) {
                    Icon(imageVector = Icons.Rounded.Menu,contentDescription = "icono", tint = Color.Black)

                }

            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f)
                .background(Color.Gray)){

            }
            Box(modifier =Modifier
                .fillMaxWidth()
                .weight(0.1f)
                .background(Color.Gray) ){

            }
        }
    }
 */


@Composable
@Preview
fun PreviewShopScreen(){
    ShoppingListScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Shopping List") })
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                ShoppingCategories()
                ShoppingItems()
            }
        }
    )
}




@Composable
fun ShoppingCategories() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Categories")
        Button(onClick = { /* TODO: Implementar navegación a categorías */ }) {
            Text("View All")
        }
    }

    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(categories.size) { index ->
            CategoryCard(category = categories[index])
        }
    }
}

@Composable
fun CategoryCard(category: Category) {
    Card(
        modifier = Modifier
            .size(80.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(category.name, style = MaterialTheme.typography.bodySmall)
            Text(category.itemCount.toString(), style = MaterialTheme.typography.labelLarge)
        }
    }
}



@Composable
fun ShoppingItemCard(shoppingItem: ShoppingItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = shoppingItem.isChecked,
                onCheckedChange = { shoppingItem.isChecked = it }
            )
            Text(shoppingItem.name, style = MaterialTheme.typography.labelLarge)
        }
    }
}
@Composable
fun ShoppingItems() {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        items(shoppingItems.size) { index ->
            ShoppingItemCard(shoppingItem = shoppingItems[index])
        }
    }
}

data class Category(val id: Int, val name: String, val itemCount: Int)

data class ShoppingItem(val id: Int, val name: String, var isChecked: Boolean)

val categories = listOf(
    Category(1, "Groceries", 10),
    Category(2, "Clothing", 5),
    Category(3, "Electronics", 2),
    Category(4, "Others", 3),
    Category(5, "Books", 5),
    Category(6, "School", 9),
)

val shoppingItems = listOf(
    ShoppingItem(1, "Milk", false),
    ShoppingItem(2, "Eggs", false),
    ShoppingItem(3, "Bread", false),
    ShoppingItem(4, "Apples", false),
    ShoppingItem(5, "Bananas", false),
    ShoppingItem(6, "T-shirt", false),
    ShoppingItem(7, "Jeans", false),
    ShoppingItem(8, "Shoes", false),
    ShoppingItem(9, "Laptop", false),
    ShoppingItem(10, "Phone", false),
    ShoppingItem(11, "Toothbrush", false),
    ShoppingItem(12, "Soap", false)
)
