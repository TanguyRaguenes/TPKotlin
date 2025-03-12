package com.example.tp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp.ui.theme.TPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                LoginPage()
        }
    }
}

@Composable
fun DesignTextField(text:String,){
    TextField(value="",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(text=text,textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        },

        );
}

@Composable
fun DesignButton(text:String,modifier: Modifier = Modifier){
    Button(
        onClick = {},
        modifier = modifier,
    ) {
        Text(text=text)
    }

}


@Composable
fun LoginPage() {
    TPTheme{
        Scaffold (modifier = Modifier.fillMaxSize() ){ innerPadding ->

            Column (modifier=Modifier.padding(innerPadding)) {
                Text(
                    text="Login",
                    modifier = Modifier.fillMaxWidth().padding(vertical = 100.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 36.sp

                )
                DesignTextField(text="Email")
                DesignTextField(text="Password")
                Row(modifier=Modifier.fillMaxWidth()){
                    DesignButton(text="Forgot password ?", modifier = Modifier.weight(1f))
                    DesignButton(text="Connexion", modifier = Modifier.weight(1f))
                }

            }
        }
    }



}


@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage()
}