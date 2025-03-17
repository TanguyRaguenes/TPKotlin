package com.example.tp.demoMVVM

import androidx.lifecycle.ViewModel
import com.example.tp.demoStateful.Person
import kotlinx.coroutines.flow.MutableStateFlow

class DemoViewModel : ViewModel() {

    var persons = MutableStateFlow<List<Person>>(
            mutableListOf(
                Person("Youpi",32),
                Person("Coucou",50),

            ))

}