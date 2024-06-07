package sample

actual class Sample {
    actual fun checkMe() = 42
}

actual object Platform {
    actual val name: String = "JVM"
}

fun main() {
    /**
     * The compiler plugin will replace this with create<MyTest>(_MyTestProvider)
     */
    val myTest = create<MyTest>()
    myTest.print()
}