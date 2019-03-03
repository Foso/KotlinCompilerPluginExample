package de.jensklingenberg.gradle

class HelloWorldGradlePlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(project: org.gradle.api.Project) {
        project.extensions.create(
            "helloWorld",
            HelloWorldGradleExtension::class.java
        )
    }
}