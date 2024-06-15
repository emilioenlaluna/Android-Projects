package com.emilio.app01

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
@Composable
@Preview(showSystemUi = true)
fun ConstraintLayoutPreview(){
    Cadena()
}

@Composable
fun  ConstraintLayoutExample(){

    ConstraintLayout {
        // Create references for the composables to constrain
        val (button, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text(
            "Text",
            Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
            }
        )
    }

}

@Composable
fun Layout(){
    ConstraintLayout (modifier = Modifier.fillMaxSize()){
        val (green, black,blue,gray,yellow) = createRefs()
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(green) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Black)
            .constrainAs(black) {
                top.linkTo(green.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(blue) {
                top.linkTo(black.top)
                start.linkTo(parent.start)
                end.linkTo(black.end)
                bottom.linkTo(black.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Gray)
            .constrainAs(gray) {

            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(yellow) {

            })
    }
}

@Composable
fun Guides(){
    ConstraintLayout {
        // Create guideline from the start of the parent at 10% the width of the Composable
        val startGuideline = createGuidelineFromStart(0.1f)
        // Create guideline from the end of the parent at 10% the width of the Composable
        val endGuideline = createGuidelineFromEnd(0.1f)
        //  Create guideline from 16 dp from the top of the parent
        val topGuideline = createGuidelineFromTop(16.dp)
        val topGuidelinePorcent = createGuidelineFromTop(0.1f)

        //  Create guideline from 16 dp from the bottom of the parent
        val bottomGuideline = createGuidelineFromBottom(16.dp)

        val (green, black,blue) = createRefs()

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(green) {
                top.linkTo(topGuideline)


            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Black)
            .constrainAs(black) {
                top.linkTo(topGuidelinePorcent)

            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(blue) {
                top.linkTo(black.bottom)
                start.linkTo(startGuideline)
            })

    }
}

@Composable
fun Barrera(){
    ConstraintLayout {


        val (green, black,blue) = createRefs()

        val barrera =createEndBarrier(green, black)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(green) {
                top.linkTo(parent.top)

            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Black)
            .constrainAs(black) {
                top.linkTo(green.bottom)

            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(blue) {
                start.linkTo(barrera)
            })

    }
}


@Composable
fun Cadena(){
    ConstraintLayout {


        val (green, black,blue) = createRefs()



        Box(modifier = Modifier
            .size(25.dp)
            .background(Color.Green)
            .constrainAs(green) {
                start.linkTo(parent.start)
                end.linkTo(black.start)

            })
        Box(modifier = Modifier
            .size(25.dp)
            .background(Color.Black)
            .constrainAs(black) {
                start.linkTo(green.end)
                end.linkTo(blue.start)

            })
        Box(modifier = Modifier
            .size(25.dp)
            .background(Color.Blue)
            .constrainAs(blue) {
                start.linkTo(black.end)
                end.linkTo(parent.end)
            })

        createHorizontalChain(green,black,black, chainStyle = ChainStyle.Spread)
        //ChainStyle.Packed
        //ChainStyle.SpreadInside
        //ChainStyle.Packed

    }
}