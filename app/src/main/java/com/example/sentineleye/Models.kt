package com.example.sentineleye

data class LoginRequest(val email: String, val password: String)

data class LoginResponse(val access_token: String)

/* data class Occurrence(val id: String, val title: String, val description: String */
