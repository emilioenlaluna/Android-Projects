package com.emilio.app01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.emilio.app01.ui.theme.App01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App01Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true,
    showSystemUi = true,
    apiLevel = 33,
    device = Devices.TABLET)
@Composable
fun GreetingPreview() {
    App01Theme {
        Greeting("Android")
    }
}


@Composable
fun MyBox(name: String){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Box(modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .background(Color.Gray) ){
            Text(text = name)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyBoxPreview(){
    MyBox(name = "Hola")

}

@Composable
@Preview(showSystemUi = true)
fun MyColumnPreview(){
    MyColumn()
}

@Composable
fun MyColumn(){
    Column(modifier= Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceEvenly) {
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Magenta)
            .fillMaxWidth()
            .height(100.dp))
    }
}

@Composable
@Preview(showSystemUi = true)
fun MyRowPreview(){
    MyRow()
}

@Composable
fun MyRow() {
    Row(modifier = Modifier
        .fillMaxSize()
        .horizontalScroll(rememberScrollState())){
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Red)
            .width(100.dp)
            .height(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Green)
            .width(100.dp)
            .height(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Yellow)
            .width(100.dp)
            .height(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Green)
            .width(100.dp)
            .height(100.dp))
        Text(text = "Ejemplo1", modifier = Modifier
            .background(Color.Magenta)
            .width(100.dp)
            .height(100.dp))

    }
}

@Composable
@Preview(showSystemUi = true)
fun MyComplexLayputPreview(){
    MyComplexLayout()
}

@Composable
fun MyComplexLayout(){
    Column (modifier=Modifier.fillMaxSize()){
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Green)){

        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)){
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Yellow), contentAlignment = Alignment.Center
            ){
                Text(text = "Hola")
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Black)){
                Text(text = "Hola")
            }

        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Red)){

        }
    }

}

