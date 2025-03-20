package com.example.tp.auth


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp.helpers.AppDialogHelpers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import com.example.tp.dtos.LoginRequestDto
import com.example.tp.dtos.RegistrationRequestDto
import com.example.tp.dtos.ResponseApiDto
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class AuthViewModel : ViewModel(){

    var loginRequestData = MutableStateFlow(LoginRequestDto())
    var registrationRequestData=MutableStateFlow(RegistrationRequestDto())


    fun login(onLoginSuccess:()->Unit={}){

        println("Email : ${loginRequestData.value.email} | password : ${loginRequestData.value.password}")

        var apiResponse:ResponseApiDto<String>;

        AppDialogHelpers.get().showDialog("Loading")

        viewModelScope.launch{

            //Simule un délai
            delay(1000)

            //Appel à l'API pour récupérer JWT
            apiResponse= AuthService.AuthApi.authService.getJwt(loginRequestData.value);
            println(apiResponse)

            //Fermer l'écran de chargement
            //Attention on doit bien se trouver dans ce scope car Async
            AppDialogHelpers.get().closeDialog();

            //Si la requête précédente me retourne un code métier 200 = réussite alors ...
            if(apiResponse.code.equals("200")){


                //Plus simple on stocke dans un service
                //dans une variable dans un companion object (donc du statique)
                //cette variable ne sera vidé qu'au redémarrage de l'app
                AuthService.token="Bearer ${apiResponse.data!!}"

                onLoginSuccess()

            }else{
                println(apiResponse.message)
            }

        }

    };

    fun registration(onRegistrationSuccess:()->Unit={}){

        println(registrationRequestData)

        var apiResponse:ResponseApiDto<RegistrationRequestDto>;

        AppDialogHelpers.get().showDialog("Loading")

        viewModelScope.launch {

            //Simule un délai
            delay(1000)

            //Appel à l'API pour s'enregistrer
            apiResponse = AuthService.AuthApi.authService.register(registrationRequestData.value);
            println(apiResponse)

            //Fermer l'écran de chargement
            //Attention on doit bien se trouver dans ce scope car Async
            AppDialogHelpers.get().closeDialog();

            //Si la requête précédente me retourne un code métier 200 = réussite alors ...
            if (apiResponse.code.equals("200")) {

                onRegistrationSuccess()

            } else {
                println(apiResponse.message)
            }
        }
    }

    fun resetPassword(onResetPasswordSuccess:()->Unit={}){

        println(loginRequestData.value.email)

        var apiResponse:ResponseApiDto<String>;

        loginRequestData.value.password="";

        AppDialogHelpers.get().showDialog("Loading")

        viewModelScope.launch {

            //Simule un délai
            delay(1000)

            //Appel à l'API pour s'enregistrer
            apiResponse = AuthService.AuthApi.authService.resetPassword(loginRequestData.value);
            println(apiResponse)

            //Fermer l'écran de chargement
            //Attention on doit bien se trouver dans ce scope car Async
            AppDialogHelpers.get().closeDialog();

            //Si la requête précédente me retourne un code métier 200 = réussite alors ...
            if (apiResponse.code.equals("200")) {

                onResetPasswordSuccess()

            } else {
                println(apiResponse.message)
            }
        }
    }
}