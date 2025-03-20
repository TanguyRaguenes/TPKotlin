package com.example.tp.articles

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp.ui.theme.DesignButton
import com.example.tp.ui.theme.DesignPage
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tp.R

class ArtActivity : ComponentActivity() {

    lateinit var viewModel: ArtViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Il faut bien l'instancier dans le onCreate
        //pour laisser le temps àl'application d'être générée
        viewModel = ArtViewModel(application);


        setContent {
            ArtActivityPage(viewModel=viewModel)
        }
    }
}

@Composable
fun ArtActivityPage(viewModel: ArtViewModel) {

    val  ArtState by viewModel.articles.collectAsState()

    DesignPage {

        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            DesignButton(
                text="Load data",
                onClick ={
                    viewModel.loadArticles();
                },

                )
            LazyColumn {
                items(ArtState){
                    element->
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Row(modifier = Modifier.padding(10.dp), horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                            AsyncImage(
                                model=element.imgPath,
                                placeholder = painterResource(R.drawable.chien),
                                error = painterResource(R.drawable.chien),
                                contentDescription = null,
                                modifier = Modifier.width(96.dp).height(96.dp),
                                contentScale = ContentScale.Crop,

                                )
                            Column (modifier = Modifier.padding(horizontal = 10.dp)) {
                                Text(
                                    text = "${element.title}",
                                    modifier = Modifier.fillMaxWidth(),
                                    color = Color.Black, fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "${element.desc}",
                                    modifier = Modifier.fillMaxWidth(),
                                    color = Color.Black,
                                )
                            }

                        }
                    }
                }
            }

        } }

}


@Preview(showBackground = true)
@Composable
fun ArtActivityPreview() {
    val application=LocalContext.current.applicationContext as Application
    val viewModel = ArtViewModel(application)
    ArtActivityPage(viewModel=viewModel)
}