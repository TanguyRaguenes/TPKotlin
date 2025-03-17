package com.example.tp.DemoApi

import com.example.tp.DemoApi.RetrofitTools.Companion.retrofit
import com.example.tp.demoStateful.Person
import retrofit2.http.GET

interface PersonService {

    @GET("persons.json")
    //suspend = équivalent de Async
    suspend  fun getPersons():List<Person>

    //Signifie j'ai un singleton
    //Pourra être accessible via cet appel : PersonApi.personService
    object PersonApi{
        val personService : PersonService by lazy { retrofit.create(PersonService::class.java) }
    }
}