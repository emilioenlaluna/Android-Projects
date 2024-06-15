package com.emilio.app01

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun EstadosPreview(){
    Estados()
}

@Composable
fun Estados(){
    var counter= remember {
        mutableStateOf(0)
    }
    Button(onClick = {
        counter.value+=1
    }) {
        Text(text = "Pulsar")
    }
    Text(text ="Has presionado el boton ${counter.value}")
}

@Composable
fun EstadosDos(){
    var counter= rememberSaveable {
        mutableStateOf(0)
    }
    Button(onClick = {
        counter.value+=1
    }) {
        Text(text = "Pulsar")
    }
    Text(text ="Has presionado el boton ${counter.value}")
}

@Composable
fun EstadosTres(){
    var counter by rememberSaveable {
        mutableStateOf(0)
    }
    Button(onClick = {
        counter +=1
    }) {
        Text(text = "Pulsar")
    }
    Text(text ="Has presionado el boton ${counter}")
}