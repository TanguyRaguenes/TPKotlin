package com.example.tp.DemoApi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp.demoStateful.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PersonViewModelApi : ViewModel() {

    var persons = MutableStateFlow<List<Person>>(
            mutableListOf(

            ))
    fun reloadPerson(){
//        persons.value=mutableListOf(
        //        )

        //Coroutine (tâche async)
        //Coroutine = bloc de code qui s'exécute de manière asynchrone et sans bloquer le thread principal.
        viewModelScope.launch{
            //Appeler le service API
            //Pour le moment : apiResponse = le retour de l'API
            //Dans notre cas getPerson retourne une liste de Person
            val apiResponse = PersonService.PersonApi.personService.getPersons()
            persons.value=apiResponse

        }

    }

}