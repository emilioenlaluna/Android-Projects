package com.emilio.app01

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun BotonesPreview(){
    Botones()
}

@Composable
fun Botones(){
    Column {
        Button(onClick = { Log.i("A","A") },
            colors=ButtonDefaults.buttonColors(containerColor = Color.Red),
            border = BorderStroke(5.dp,Color.Gray)
        ) {
            Text(text = "Presionar")
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Hola")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Contenido")
        }

    }


}