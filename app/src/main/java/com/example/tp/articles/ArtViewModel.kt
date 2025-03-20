package com.example.tp.articles

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import com.example.tp.Articles.ArtModel
import com.example.tp.R
import com.example.tp.helpers.AppDialogHelpers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//Il ne faut pas mettre val application ci-dessous
// car AndroidViewModel dispose déjà d'un attribut application et de ce fait risque de croire qu'on veut override
class ArtViewModel(application:Application) : AndroidViewModel(application) {

    var articles = MutableStateFlow<List<ArtModel>>(mutableListOf());


    fun loadArticles(){

        val message  = getApplication<Application>().getString(R.string.app_message_loading_data)
        AppDialogHelpers.get().showDialog(message)

        viewModelScope.launch{

            //Simule un délai
            delay(1000)

            val apiResponse = ArtService.ArticlesApi.artService.getArticles();


            //Fermer l'écran de chargement
            //Attention on doit bien se trouver dans ce scope car Async
            AppDialogHelpers.get().closeDialog();

            println(apiResponse.message)

            if(apiResponse.code.equals("200")){
                articles.value=apiResponse.data!!;
            }

        }
    }
}