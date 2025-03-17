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

class DemoStateFul2Activity : ComponentActivity() {

    var person= MutableStateFlow<Person>(Person("Youpi",32))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoStateFul2(person=person)
        }
    }
}

@Composable
fun DemoStateFul2(person:MutableStateFlow<Person>) {

    val personState by person.collectAsState()

    DesignPage {

        val context = LocalContext.current

        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text="Compteur : ${personState.pseudo}")

            DesignButton(
                text="Incrementer",
                onClick ={

                    person.value=person.value.copy(pseudo="Titi")
                },

            )

        } }

}


@Preview(showBackground = true)
@Composable
fun DemoStateFul2Preview() {
    //Déclarer un compteur en entier écoutable
    var person= MutableStateFlow<Person>(Person("Youpi",32))
    DemoStateFul2(person=person)
}