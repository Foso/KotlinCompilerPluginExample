pluginManagement {
    plugins {

        kotlin("multiplatform") version "1.8.0" apply false
    }
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()

        maven { url = java.net.URI("https://maven.google.com") }

        maven { url = java.net.URI("https://plugins.gradle.org/m2/") }
    }

    dependencyResolutionManagement {
        repositories {
            google()
            mavenCentral()
            // your repos
        }
    }


}
rootProject.name = "KotlinCompilerExample"
include(":testproject")
