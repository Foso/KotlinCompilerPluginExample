package sample

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.builtin.CallResponseConverter
import de.jensklingenberg.ktorfit.converter.builtin.FlowResponseConverter
import de.jensklingenberg.ktorfit.create
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

expect class Sample() {
    fun checkMe(): Int
}

expect object Platform {
    val name: String
}

interface Github {

    @GET("posts")
    suspend fun hallo(): String
}

interface Github2 {

    @GET("posts")
    suspend fun hallo(): String
}


fun hello(): String = "Hello from ${Platform.name}"


val ktorfit = ktorfit {
    baseUrl("https://swapi.dev/api/")
    httpClient(HttpClient {
        install(ContentNegotiation) {
            json(Json { isLenient = true; ignoreUnknownKeys = true })
        }
    })
    responseConverter(FlowResponseConverter(), CallResponseConverter())
}


val starWarsApi = ktorfit.create<StarWarsApi>()


fun loadData() {
    GlobalScope.launch {
        val response = starWarsApi.getPersonByIdResponse(3)

    }
}