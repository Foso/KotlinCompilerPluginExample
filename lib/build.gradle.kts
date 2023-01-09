plugins {
    id("org.jetbrains.kotlin.multiplatform") version "1.8.0"
    id("com.google.devtools.ksp")
    id("com.android.library")
    id("kotlinx-serialization")

}
apply(plugin = "compiler.gradleplugin.helloworld")


configure<de.jensklingenberg.gradle.TestCompilerExtension> {
    enabled = true
}

ksp {

}
val ktorfitVersion = "1.0.0-beta17"


android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
}
val ktorVersion = "2.2.2"

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }
    jvm()
    linuxX64("linux")
    js(IR) {
        this.nodejs()
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("de.jensklingenberg.ktorfit:ktorfit-lib:$ktorfitVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            }
        }

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


dependencies {
    add("kspCommonMainMetadata", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion")
    add("kspJvm", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion")
    add("kspJs", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion")
}

tasks.build {
    dependsOn(":kotlin-native-plugin:publishToMavenLocal")
    //  dependsOn(":kotlin-plugin:publishToMavenLocal")

}


configurations.all {
    resolutionStrategy {
        force("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-native-mt")
    }
}

