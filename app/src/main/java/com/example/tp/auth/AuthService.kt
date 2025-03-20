package com.example.tp.auth

import com.example.tp.RetrofitTools.RetrofitTools.Companion.retrofit
import com.example.tp.dtos.JwtDto
import com.example.tp.dtos.ResponseApiDto
import com.example.tp.dtos.LoginRequestDto
import com.example.tp.dtos.RegistrationRequestDto
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {

    companion object{
        var token:String="";
    }

    @POST("login")
    suspend fun getJwt(@Body loginRequest: LoginRequestDto):ResponseApiDto<String>

    @POST("signup")
    suspend fun register(@Body registerRequest: RegistrationRequestDto):ResponseApiDto<RegistrationRequestDto>

    @POST("reset-password")
    suspend fun resetPassword(@Body loginRequest: LoginRequestDto):ResponseApiDto<String>

    @GET("check")
    suspend fun check(@Header("Authorization") token: String?):ResponseApiDto<String>

    object AuthApi{
        val authService : AuthService by lazy {
            retrofit.create(AuthService::class.java)
        }
    }

}