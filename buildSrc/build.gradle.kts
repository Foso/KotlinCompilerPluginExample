import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.0"
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://maven.google.com")
        maven("https://plugins.gradle.org/m2/")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}



tasks.build {
    dependsOn(":compiler-plugin:kotlin-plugin:publishToMavenLocal")
    dependsOn(":compiler-plugin:kotlin-native-plugin:publishToMavenLocal")

    dependsOn(":gradle-plugin:publishToMavenLocal")
}