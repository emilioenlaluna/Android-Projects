package com.emilio.app01

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MyTextFieldPreview(){
    MyTextFieldTres()
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(){
    var contenido by rememberSaveable {
        mutableStateOf("")
    }
   Column {
       TextField(value = contenido, onValueChange ={contenido=it}, label = { Text(text = "Ingresa tu nommbre")} )

   }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldDos(){
    var contenido by rememberSaveable {
        mutableStateOf("")
    }
    Column {
        TextField(value = contenido, onValueChange ={

            contenido=if(it.contains("a")){
                it.replace("a","")
            }else{
                it
            }
                                                    }, label = { Text(text = "Ingresa tu nommbre")} )

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldTres(){
    var contenido by rememberSaveable {
        mutableStateOf("")
    }
    Column {
        OutlinedTextField(value = contenido, onValueChange ={contenido=it}, label = { Text(text = "Ingresa tu nommbre")} ,colors=TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Magenta
        ))

    }

}