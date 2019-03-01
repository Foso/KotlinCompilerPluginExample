package de.jensklingenberg

import com.google.auto.service.AutoService
import com.intellij.mock.MockProject
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.config.kotlinSourceRoots
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration

@AutoService(ComponentRegistrar::class)
class NativeTestComponentRegistrar : ComponentRegistrar {


    override fun registerProjectComponents(project: MockProject, configuration: CompilerConfiguration) {

        val messageCollector = configuration.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)

        configuration.kotlinSourceRoots.filter { !it.isCommon }.forEach {
            messageCollector.report(
                CompilerMessageSeverity.WARNING,
                "*** Hello from ***" + configuration.kotlinSourceRoots.firstOrNull()?.path
            )
        }



    }
}
