package com.example.tp.demoStateful

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp.AppViewHelper
import com.example.tp.auth.LoginActivity
import com.example.tp.ui.theme.DesignButton
import com.example.tp.ui.theme.DesignPage
import kotlinx.coroutines.flow.MutableStateFlow

class DemoStateFulActivity : ComponentActivity() {

    //Déclarer un compteur en entier écoutable
    var counter = MutableStateFlow<Int>(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoStateFul(counter = counter)
        }
    }
}

@Composable
fun DemoStateFul(counter:MutableStateFlow<Int>) {

    val counterState by counter.collectAsState()
    //A chaque fois que counter change on va rafraichir le composant

    DesignPage {

        //Récupérer le contexte de l'application
        val context = LocalContext.current

        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text="Compteur : ${counterState}")

            DesignButton(
                text="Incrementer",
                onClick ={
                    counter.value+=1
                },

            )

        } }

}


@Preview(showBackground = true)
@Composable
fun DemoStateFulPreview() {
    //Déclarer un compteur en entier écoutable
    var counter = MutableStateFlow<Int>(0)
    DemoStateFul(counter = counter)
}