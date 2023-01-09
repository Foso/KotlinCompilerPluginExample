buildscript {

    repositories {
        mavenLocal()
        google()
        mavenCentral()
    }

    dependencies {
        classpath("de.jensklingenberg:gradle-plugin:1.0.0")
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.8.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")

    }
}
plugins {
    id("org.jetbrains.kotlin.multiplatform") version "1.8.0" apply false
    id("com.google.devtools.ksp") version "1.8.0-1.0.8" apply false
}

System.setProperty("kotlin.compiler.execution.strategy", "in-process") // For debugging



allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://maven.google.com")
        maven("https://plugins.gradle.org/m2/")
        google()
    }
}

