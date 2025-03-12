package com.example.tp.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp.R


@Composable
fun DesignPage(content: @Composable () -> Unit){
    TPTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(modifier=Modifier.padding(innerPadding)) {
                Image(
                    painter = painterResource(R.drawable.pink_flavour_bg),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Column(
                    modifier = Modifier.padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    content()

                }
            }

        }
    }
}


@Composable
fun ConditionalIcon(icon: ImageVector?){
    if(icon!=null){
        Icon(imageVector = icon, contentDescription = null, tint = Color(color = 0xffffffff))
    }
}

@Composable
fun DesignTextField(text:String, icon: ImageVector?){
    TextField(value="",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        leadingIcon = { ConditionalIcon(icon)},
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(color=0x55000000),
            focusedContainerColor = Color(color=0xDD000000),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(10.dp),
        placeholder = {
            Text(
                text=text,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                color = Color(color=0xFFFFFFFF),
                fontSize = 20.sp,
            )
        },

        );
}

@Composable
fun DesignButton(text:String,modifier: Modifier = Modifier){
    Button(
        onClick = {},
        modifier = modifier,
        border= BorderStroke(width=2.dp, color=Color(100,0,255,100)),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(100,0,255,150),
            contentColor = Color(255,255,255,255),
            //disabledContainerColor = Color(color = 0xFFFFFFFF),
            //disabledContentColor = Color(color = 0xFFFFFFFF)
        )

    ) {
        Box(
            modifier=Modifier.background(
                brush = Brush.linearGradient(
                    listOf(Color.Gray, Color.DarkGray)
                )
            ).fillMaxSize()
        ){
            Text(text=text)
        }


    }

}
