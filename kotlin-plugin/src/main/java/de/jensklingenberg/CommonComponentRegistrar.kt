package de.jensklingenberg

import com.google.auto.service.AutoService
import org.jetbrains.kotlin.backend.common.IrElementTransformerVoidWithContext
import org.jetbrains.kotlin.backend.common.extensions.FirIncompatiblePluginAPI
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.config.kotlinSourceRoots
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.compiler.plugin.CompilerPluginRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.descriptors.toIrBasedKotlinType
import org.jetbrains.kotlin.ir.expressions.IrCall
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.impl.IrConstructorCallImpl
import org.jetbrains.kotlin.ir.symbols.impl.IrConstructorSymbolImpl
import org.jetbrains.kotlin.ir.types.classFqName
import org.jetbrains.kotlin.ir.types.impl.IrSimpleTypeBuilder
import org.jetbrains.kotlin.ir.types.impl.IrSimpleTypeImpl
import org.jetbrains.kotlin.ir.types.impl.buildSimpleType
import org.jetbrains.kotlin.ir.util.constructors
import org.jetbrains.kotlin.ir.util.dump
import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name

@AutoService(CompilerPluginRegistrar::class)
class CommonComponentRegistrar : CompilerPluginRegistrar() {

    override val supportsK2: Boolean
        get() = true

    override fun ExtensionStorage.registerExtensions(configuration: CompilerConfiguration) {
        if (configuration[KEY_ENABLED] == false) {
            return
        }

        val messageCollector = configuration.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)
        configuration.kotlinSourceRoots.forEach {
            messageCollector.report(
                CompilerMessageSeverity.WARNING,
                "*** Hello from ***" + it.path
            )
        }
        IrGenerationExtension.registerExtension(
            RedactedIrGenerationExtension(messageCollector)
        )
    }
}


class RedactedIrGenerationExtension(val messageCollector: MessageCollector) : IrGenerationExtension {
    override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {

        moduleFragment.transform(Test33(pluginContext, messageCollector), null)
    }

}

class Test33(private val irPluginContext: IrPluginContext, val messageCollector: MessageCollector) :
    IrElementTransformerVoidWithContext() {

    override fun visitExpression(expression: IrExpression): IrExpression {
        (expression as? IrCall)?.let {
            if (it.typeArgumentsCount > 0) {
                if (expression.symbol.owner.name.asString() != "create") {
                    return expression
                }
            }
        }
        return expression
    }

    override fun visitCall(expression: IrCall): IrExpression {
        expression.transform(Trafo(irPluginContext, messageCollector), null)

        return super.visitCall(expression)
    }


}

class Trafo(val irPluginContext: IrPluginContext, val messageCollector: MessageCollector) :
    IrElementTransformerVoidWithContext() {


    override fun visitExpression(expression: IrExpression): IrExpression {

        //expression.transformChildren(this, null)

        (expression as? IrCall)?.let {
            if (it.typeArgumentsCount > 0) {
                if (expression.symbol.owner.name.asString() != "create") {
                    return expression
                }
                if (!expression.symbol.owner.symbol.toString().contains("de.jensklingenberg.ktorfit.ktorfit")) {
                    // return expression
                }
                messageCollector.report(CompilerMessageSeverity.WARNING, expression.dump())

                val arg = it.getTypeArgument(0) ?: return expression
                messageCollector.report(CompilerMessageSeverity.WARNING, "ARG*:" + arg.classFqName!!.asString())
                val packageName = arg.classFqName?.asString()?.substringBefore(".")
                    ?: throw NullPointerException("pack " + expression.dump())
                val className = arg.classFqName?.asString()?.substringAfterLast(".") ?: ""

                val testClass = irPluginContext.referenceClass(
                    ClassId(
                        FqName(packageName),
                        Name.identifier("_$className" + "Impl"),
                    )
                )

                val newCont = testClass?.constructors?.first() ?: throw NullPointerException(expression.dump())

                val bui = IrSimpleTypeBuilder()

                bui.classifier = testClass
                bui.kotlinType = arg.toIrBasedKotlinType()


                val newCall = IrConstructorCallImpl(0, 0, type = bui.buildSimpleType(), symbol = newCont, 0, 0, 0, null)

                it.putValueArgument(0, newCall)
                return super.visitExpression(it)
            }
        }
        return super.visitExpression(expression)
    }


}




