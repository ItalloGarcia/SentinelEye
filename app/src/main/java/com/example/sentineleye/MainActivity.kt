package com.example.sentineleye;

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sentineleye.ApiService
import com.example.sentineleye.LoginRequest
import com.example.sentineleye.LoginResponse
import com.example.sentineleye.services.AuthenticationService
import com.example.sentineleye.ui.theme.SentinelEyeTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : ComponentActivity() {

    private val authenticationService = AuthenticationService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SentinelEyeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
        authenticationService.doLogin("italoaglagarcia@gmail.com", "310205477")
    }
    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        SentinelEyeTheme {
            Greeting("Android")
        }
    }
}
