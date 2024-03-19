package com.example.sentineleye

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login")
    fun login(@Body body: LoginRequest): Call<LoginResponse>

}