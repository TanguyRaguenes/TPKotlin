package com.example.tp.articles

//class ResponseApiDto(var code : String="", var message:String="") {}

//class ResponseListArtApiDto(var code : String="", var message:String="", var date : List<ArtModel>) {}

//class ResponseStringApiDto(var code : String="", var message:String="", var date : String) {}

//...


//On utilise à la place la généricité ; à la place de T on peut mettre ce qu'on veut (titi, youpi...)
//Le point d'interrogation signifie que cela peut-êre nullable
class ResponseApiDto<T>(var code : String="", var message:String="", var data: T?) {}
