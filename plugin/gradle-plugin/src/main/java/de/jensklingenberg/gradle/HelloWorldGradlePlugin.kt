package de.jensklingenberg.gradle

open class HelloWorldGradlePlugin : org.gradle.api.Plugin<org.gradle.api.Project> {

    /** If [false], this plugin won't actually be applied */
    var enabled: Boolean = true

    override fun apply(project: org.gradle.api.Project) {
        project.extensions.create(
            "helloWorld",
            this::class.java
        )
    }
}