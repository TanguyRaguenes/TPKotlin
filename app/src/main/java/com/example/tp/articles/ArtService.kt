package com.example.tp.articles


import com.example.tp.Articles.ArtModel
import com.example.tp.articles.ArtRetrofitTools.Companion.retrofit
import retrofit2.http.GET

interface ArtService {

    @GET("articles")
    suspend fun getArticles():ResponseApiDto<List<ArtModel>>

    object ArticlesApi{
        val artService : ArtService by lazy {
            retrofit.create(ArtService::class.java)
        }
    }

}