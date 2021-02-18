package de.jensklingenberg.gradle

import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilerPluginSupportPlugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption

open class TestCompilerExtension {
    var enabled: Boolean = true
}

class HelloWorldGradleSubPlugin : KotlinCompilerPluginSupportPlugin {

    private var gradleExtension : TestCompilerExtension = TestCompilerExtension()

    override fun applyToCompilation(kotlinCompilation: KotlinCompilation<*>): Provider<List<SubpluginOption>> {
        gradleExtension = kotlinCompilation.target.project.extensions.findByType(TestCompilerExtension::class.java)
            ?: TestCompilerExtension()
        val project = kotlinCompilation.target.project

        return project.provider {
            val options = mutableListOf<SubpluginOption>(SubpluginOption("enabled", gradleExtension.enabled.toString()))
            options
        }
    }

    override fun apply(target: Project) {
        target.extensions.create(
            "helloWorld",
            TestCompilerExtension::class.java
        )
        super.apply(target)
    }

    /**
     * Just needs to be consistent with the key for CommandLineProcessor#pluginId
     */
    override fun getCompilerPluginId(): String = "helloWorldPlugin"

    override fun getPluginArtifact(): SubpluginArtifact = SubpluginArtifact(
        groupId = "de.jensklingenberg",
        artifactId = "kotlin-compiler-plugin",
        version = "0.0.1" // remember to bump this version before any release!
    )

    override fun isApplicable(kotlinCompilation: KotlinCompilation<*>): Boolean {
        return true
    }

    override fun getPluginArtifactForNative(): SubpluginArtifact = SubpluginArtifact(
        groupId = "de.jensklingenberg",
        artifactId = "kotlin-compiler-native-plugin",
        version = "0.0.1" // remember to bump this version before any release!
    )
}
