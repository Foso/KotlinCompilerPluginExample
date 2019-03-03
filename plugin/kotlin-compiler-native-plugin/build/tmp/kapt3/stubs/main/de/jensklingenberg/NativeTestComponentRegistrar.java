package de.jensklingenberg;

@com.google.auto.service.AutoService(value = {org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar.class})
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lde/jensklingenberg/NativeTestComponentRegistrar;", "Lorg/jetbrains/kotlin/compiler/plugin/ComponentRegistrar;", "()V", "test", "", "getTest", "()Ljava/lang/String;", "setTest", "(Ljava/lang/String;)V", "registerProjectComponents", "", "project", "Lcom/intellij/mock/MockProject;", "configuration", "Lorg/jetbrains/kotlin/config/CompilerConfiguration;", "kotlin-compiler-native-plugin"})
public final class NativeTestComponentRegistrar implements org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar {
    @org.jetbrains.annotations.NotNull()
    public java.lang.String test;

    public NativeTestComponentRegistrar() {
        super();
    }

    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTest() {
        return null;
    }

    public final void setTest(@org.jetbrains.annotations.NotNull()
                                      java.lang.String p0) {
    }

    @java.lang.Override()
    public void registerProjectComponents(@org.jetbrains.annotations.NotNull()
                                                  com.intellij.mock.MockProject project, @org.jetbrains.annotations.NotNull()
                                                  org.jetbrains.kotlin.config.CompilerConfiguration configuration) {
    }
}