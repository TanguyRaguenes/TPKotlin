package com.example.tp.DemoApi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp.demoStateful.Person
import com.example.tp.ui.theme.DesignButton
import com.example.tp.ui.theme.DesignPage
import androidx.compose.foundation.lazy.items

class PersonViewModelActivity : ComponentActivity() {

    //Déclarer un View Model
    var viewModel = PersonViewModelApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PersonViewModel(viewModel=viewModel)
        }
    }
}

@Composable
fun PersonViewModel(viewModel: PersonViewModelApi) {

    val personsState by viewModel.persons.collectAsState()

    DesignPage {

        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DesignButton(
                text="Appel API",
                onClick ={

                    viewModel.reloadPerson()
                },

                )
            LazyColumn {
                items(personsState){element->
                    Text(text="Pseudo : ${element.pseudo}")
                }
            }

        } }

}


@Preview(showBackground = true)
@Composable
fun DemoViewModelPreview() {
    var viewModel = PersonViewModelApi()
    PersonViewModel(viewModel=viewModel)
}