package sample

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.create
import de.jensklingenberg.ktorfit.internal.KtorfitClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

actual class Sample {
    actual fun checkMe() = 42
}

actual object Platform {
    actual val name: String = "JVM"
}


interface Hallo {
    fun test()
}


fun main() {

    runBlocking {
        val response = starWarsApi.getPersonByIdResponse(3)
        println(response)
    }

}




