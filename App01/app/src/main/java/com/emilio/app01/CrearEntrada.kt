package com.emilio.app01

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showSystemUi = true)
fun CrearNotaPreviwe(){
    crearNota()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun crearNota(){

    var contenido by rememberSaveable {
        mutableStateOf("")
    }

    Column {
        OutlinedTextField(value = contenido, onValueChange ={contenido=it}, label = { Text(text = "Ingresa tu nommbre") } ,colors= TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Magenta
        ))

    }

}