package com.emilio.app01

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
@Preview(showBackground = true)
fun TextosPreview(){
    Textos()
}

@Composable
fun Textos(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hola Mundo")
        Text(text = "Hola Mundo", color = Color.Blue)
        Text(text = "Hola Mundo", fontWeight = FontWeight.Bold)
        Text(text = "Hola Mundo", fontWeight = FontWeight.ExtraLight)
        Text(text = "Hola Mundo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = "Hola Mundo", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(text = "Hola Mundo", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(text = "Hola Mundo", fontSize = 30.sp)
    }
}