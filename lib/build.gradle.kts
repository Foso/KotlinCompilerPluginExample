plugins {
    id("org.jetbrains.kotlin.multiplatform") version "1.8.20"
}
apply(plugin = "compiler.gradleplugin.helloworld")


configure<de.jensklingenberg.gradle.TestCompilerExtension> {
    enabled = true
}

kotlin {
    jvm()
    linuxX64("linux")
    js()
    sourceSets {
        val commonMain by getting {}

        val jsMain by getting {

            dependencies {

            }
        }

        val jvmMain by getting {


            dependencies {

            }
        }
        val linuxMain by getting {

        }

    }
}

