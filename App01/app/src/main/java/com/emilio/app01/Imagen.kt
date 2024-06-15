package com.emilio.app01

import android.widget.ProgressBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun Imagen(){
    Column {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription ="Ejemplo" )
    }
}

@Composable
fun ImagenAdvanced(){
    Column {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription ="Ejemplo",modifier= Modifier
            .clip(
                CircleShape
            )
            .border(5.dp, Color.Red, CircleShape) )
    }
}


@Composable
@Preview(showSystemUi = true)
fun ImagePreview(){
    Iconos()
}


@Composable
fun Iconos(){
    Column {
        Icon(imageVector = Icons.Rounded.Star,contentDescription = "icono", tint = Color.Black)

       CircularProgressIndicator(color = Color.Red, modifier = Modifier.padding(top = 10.dp), strokeWidth = 5.dp)
        LinearProgressIndicator(color = Color.Red)
    }
}

