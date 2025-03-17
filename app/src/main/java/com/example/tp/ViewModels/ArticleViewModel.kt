package com.example.tp.ViewModels

import androidx.lifecycle.ViewModel
import com.example.tp.Models.ArticleModel
import kotlinx.coroutines.flow.MutableStateFlow

class ArticleViewModel:ViewModel() {

    var articlesList = MutableStateFlow<List<ArticleModel>>(
        mutableListOf(
            ArticleModel(title = "Livre1",desc="Description1",imgPath="https://cdn.pixabay.com/photo/2025/03/09/16/02/hare-9457418_1280.jpg"),
            ArticleModel(title = "Livre2",desc="Description2",imgPath="https://cdn.pixabay.com/photo/2024/05/19/13/27/daisies-8772617_1280.jpg"),
            ArticleModel(title = "Livre3",desc="Description3",imgPath="https://cdn.pixabay.com/photo/2025/02/14/13/46/crested-tit-9406740_1280.jpg"),
        )
    )
}