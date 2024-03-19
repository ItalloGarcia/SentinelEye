package com.example.sentineleye.services

import com.example.sentineleye.ApiService
import com.example.sentineleye.LoginRequest
import com.example.sentineleye.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class AuthenticationService {

    private val baseUrl = "https://api-service.fogocruzado.org.br/api/v2/" //TODO: User env var

    private val apiService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun doLogin(email: String, password: String) {
        val loginRequest = LoginRequest(email, password)

        try {
            apiService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        val accessToken = response.body()?.data?.get("accessToken").toString()

                        if (accessToken.isEmpty())
                            println("Erro ao obter access token")

                        println("Access Token: $accessToken")
                    } else {
                        println("Erro ao fazer requisição POST: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }catch(e: Exception) {
            println(e.printStackTrace())
        }
    }
}