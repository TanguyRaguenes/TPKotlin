package com.example.tp.dtos

class ResponseApiDto<T>(var code : String="", var message:String="", var data: T?) {}