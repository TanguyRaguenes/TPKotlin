package com.example.tp.demoMVVM

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
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.compose.foundation.lazy.items

class DemoViewModelActivity : ComponentActivity() {

    //Déclarer un View Model
    var viewModel = DemoViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoViewModel(viewModel=viewModel)
        }
    }
}

@Composable
fun DemoViewModel(viewModel: DemoViewModel) {

    val personsState by viewModel.persons.collectAsState()

    DesignPage {

        val context = LocalContext.current

        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LazyColumn {
                items(personsState){element->
                    Text(text="Pseudo : ${element.pseudo}")
                }
            }

            DesignButton(
                text="Incrementer",
                onClick ={

                    viewModel.persons.value+=Person("Titi",69)
                },

                )
        } }

}


@Preview(showBackground = true)
@Composable
fun DemoViewModelPreview() {
    var viewModel = DemoViewModel()
    DemoViewModel(viewModel=viewModel)
}