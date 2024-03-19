package com.example.sentineleye

import com.google.gson.internal.LinkedTreeMap

data class LoginRequest(val email: String, val password: String)

data class LoginResponse(val data: LinkedTreeMap<String, Any>)

/* data class Occurrence(val id: String, val title: String, val description: String */
