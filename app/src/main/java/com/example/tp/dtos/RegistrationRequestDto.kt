package com.example.tp.dtos

data class RegistrationRequestDto(
    var email:String="abc@gmail.com",
    var password:String="mdp",
    var passwordConfirm:String="mdp",
    var pseudo:String="Tanguy",
    var cityCode:String?="",
    var city:String?="",
    var phone:String?=""
) {
}