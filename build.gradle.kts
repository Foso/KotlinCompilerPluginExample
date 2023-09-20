import org.gradle.kotlin.dsl.libs

buildscript {

    repositories {
        mavenLocal()
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.vanniktech:gradle-maven-publish-plugin:0.25.3")
        classpath("de.jensklingenberg:gradle-plugin:1.0.0")
    }
}
plugins {
    id("org.jetbrains.kotlin.multiplatform") version libs.versions.kotlin apply false
}
apply(plugin = "compiler.gradleplugin.helloworld")

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

