package com.example.tp.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import com.example.tp.AppViewHelper
import com.example.tp.Models.ArticleModel
import com.example.tp.R
import com.example.tp.ViewModels.ArticleViewModel
import com.example.tp.auth.LoginActivity
import com.example.tp.demoStateful.Person
import com.example.tp.ui.theme.DesignButton
import com.example.tp.ui.theme.DesignPage
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

class ArticlesPageActivity : ComponentActivity() {

    private val viewModel = ArticleViewModel();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticlesPage(viewModel=viewModel)
        }
    }
}

@Composable
fun ArticlesPage(viewModel:ArticleViewModel) {

    val articlesState by viewModel.articlesList.collectAsState()

    DesignPage {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


//        AsyncImage(
//            model="https://cdn.pixabay.com/photo/2025/03/09/16/02/hare-9457418_1280.jpg",
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//
//        )

            LazyColumn {
                items(articlesState){element->
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
                item {
                    DesignButton(
                        text="Add new article",
                        onClick ={
                            viewModel.articlesList.value+= ArticleModel(title = "Livre4",desc="Description4",imgPath="https://erreur.jpg")
                        })

                }
            }



        }}

}


@Preview(showBackground = true)
@Composable
fun ArticlesPagePreview() {
    val viewModel = ArticleViewModel();
    ArticlesPage(viewModel=viewModel);
}