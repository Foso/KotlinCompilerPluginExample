import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version("1.8.10")
    kotlin("kapt") version("1.8.10")
    id("com.vanniktech.maven.publish") version("0.23.1")
    `maven-publish`
    signing

}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://maven.google.com")
        maven("https://plugins.gradle.org/m2/")
        google()
    }
}
mavenPublishing {
    publishToMavenCentral()

}

group = "de.jensklingenberg"
version = "0.0.1"
val autoService = "1.0.1"
dependencies {
    compileOnly("com.google.auto.service:auto-service:$autoService")
    kapt("com.google.auto.service:auto-service:$autoService")
    compileOnly("org.jetbrains.kotlin:kotlin-compiler-embeddable:1.8.10")
    testImplementation("dev.zacsweers.kctfork:core:0.2.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation(kotlin("reflect"))

}

tasks.register("sourcesJar", Jar::class) {
    group = "build"
    description = "Assembles Kotlin sources"

    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
    dependsOn(tasks.classes)
}

publishing {
    publications {
        create<MavenPublication>("default") {
            from(components["java"])
            artifact(tasks["sourcesJar"])

            pom {
                name.set("compiler-plugin")
                description.set("Hello World Compiler Plugin")
                url.set("https://github.com/Foso/KotlinCompilerPluginExample")

                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("https://github.com/Foso/KotlinCompilerPluginExample/blob/master/LICENSE.txt")
                    }
                }
                scm {
                    url.set("https://github.com/Foso/KotlinCompilerPluginExample")
                    connection.set("scm:git:git://github.com/Foso/KotlinCompilerPluginExample.git")
                }
                developers {
                    developer {
                        name.set("Developer Name")
                        url.set("Developer URL")
                    }
                }
            }
        }
    }

    repositories {
        if (
            hasProperty("sonatypeUsername") &&
            hasProperty("sonatypePassword") &&
            hasProperty("sonatypeSnapshotUrl") &&
            hasProperty("sonatypeReleaseUrl")
        ) {
            maven {
                val url = when {
                    "SNAPSHOT" in version.toString() -> property("sonatypeSnapshotUrl")
                    else -> property("sonatypeReleaseUrl")
                } as String
                setUrl(url)
                credentials {
                    username = property("sonatypeUsername") as String
                    password = property("sonatypePassword") as String
                }
            }
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
tasks.withType<KotlinCompilationTask<*>>().configureEach {
    compilerOptions.freeCompilerArgs.add("-opt-in=org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi")
}

//./gradlew clean :lib:compileKotlinJvm --no-daemon -Dorg.gradle.debug=true -Dkotlin.compiler.execution.strategy="in-process" -Dkotlin.daemon.jvm.options="-Xdebug,-Xrunjdwp:transport=dt_socket,address=5005,server=y,suspend=n"
