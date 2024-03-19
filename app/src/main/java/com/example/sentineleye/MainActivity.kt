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
import com.example.sentineleye.ui.theme.SentinelEyeTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



 class MainActivity : ComponentActivity() {

    private val baseUrl = "https://api-service.fogocruzado.org.br/api/v2/"

    private val apiService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SentinelEyeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
        fazerRequisicaoPOST()
    }
    private fun fazerRequisicaoPOST() {
        val loginRequest = LoginRequest("teste", "teste")

        apiService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val accessToken = response.body()?.access_token
                    if (accessToken != null) {
                        println("Access Token: $accessToken")
                    } else {
                        println("Erro ao obter access token")
                    }
                } else {
                    println("Erro ao fazer requisição POST: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
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
