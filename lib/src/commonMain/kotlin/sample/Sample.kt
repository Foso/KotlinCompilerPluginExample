package sample

expect class Sample() {
    fun checkMe(): Int
}

expect object Platform {
    val name: String
}

fun hello(): String = "Hello from ${Platform.name}"

class _MyTestProvider : MyTest{
    override fun print(){
        println("Hello from _MyTestProvider")
    }
}

interface MyTest{
    fun print()
}

fun <T> create(myTestProvider: MyTest? = null): MyTest {
    return myTestProvider!!
}