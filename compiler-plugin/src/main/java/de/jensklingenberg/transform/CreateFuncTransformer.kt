package de.jensklingenberg.transform

import de.jensklingenberg.DebugLogger
import org.jetbrains.kotlin.backend.common.IrElementTransformerVoidWithContext
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.expressions.IrCall
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.impl.IrConstructorCallImpl
import org.jetbrains.kotlin.ir.types.classFqName
import org.jetbrains.kotlin.ir.types.defaultType
import org.jetbrains.kotlin.ir.types.impl.originalKotlinType
import org.jetbrains.kotlin.ir.util.constructors
import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name

/**
 * Transform create<TestApi>() to create<TestApi>(_TestApiIProvider())
 */
internal class CreateFuncTransformer(
    private val pluginContext: IrPluginContext,
    private val debugLogger: DebugLogger
) : IrElementTransformerVoidWithContext() {

    companion object {

        fun ERROR_IMPL_NOT_FOUND(implName: String) =
            "${implName} not found"

        private const val EXAMPLE_PACKAGE = "sample"
        private const val EXAMPLE_CREATE = "create"

    }

    override fun visitExpression(expression: IrExpression): IrExpression {

        //Find exampleKtorfit.create<TestApi>()
        (expression as? IrCall)?.let { irCall ->
            if (irCall.typeArgumentsCount > 0) {

                if (!expression.symbol.owner.symbol.toString().contains(EXAMPLE_PACKAGE)) {
                    return expression
                }
                if (expression.symbol.owner.name.asString() != EXAMPLE_CREATE) {
                    return expression
                }

                if (expression.getValueArgument(0) != null) {
                    return expression
                }

                //Get T from create<T>()
                val argumentType = irCall.getTypeArgument(0) ?: return expression
                val classFqName = argumentType.classFqName

                //if (!argumentType.isInterface()) throw IllegalStateException(ERROR_TYPE_ARGUMENT_NOT_INTERFACE(argumentType.originalKotlinType.toString()))

                if (classFqName == null) {
                    throw IllegalStateException(ERROR_IMPL_NOT_FOUND(argumentType.originalKotlinType.toString()))
                }

                val packageName = classFqName.packageName
                val className = classFqName.shortName().toString()
                val providerClassName = "_$className" + "Provider"

                //Find the class _TestApiProvider
                val implClassSymbol = pluginContext.referenceClass(
                    ClassId(
                        FqName(packageName),
                        Name.identifier(providerClassName)
                    )
                ) ?: throw IllegalStateException(ERROR_IMPL_NOT_FOUND(providerClassName))

                val newConstructor = implClassSymbol.constructors.first()

                //Create the constructor call for _ExampleApiImpl()
                val newCall = IrConstructorCallImpl(
                    0,
                    0,
                    type = implClassSymbol.defaultType,
                    symbol = newConstructor,
                    0,
                    0,
                    0,
                    null
                )

                //Set _ExampleApiImpl() as argument for create<ExampleApi>()
                irCall.putValueArgument(0, newCall)
                debugLogger.log(
                    "Transformed " + argumentType.originalKotlinType.toString() + " to _$className" + "Impl"
                )
                return super.visitExpression(irCall)
            }
        }
        return super.visitExpression(expression)
    }

}


private val FqName?.packageName: String
    get() {
        return this.toString().substringBeforeLast(".")
    }
