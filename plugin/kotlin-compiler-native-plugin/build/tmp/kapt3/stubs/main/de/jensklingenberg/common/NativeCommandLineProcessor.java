package de.jensklingenberg.common;

import java.lang.System;

@com.google.auto.service.AutoService(value = {org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor.class})
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lde/jensklingenberg/common/NativeCommandLineProcessor;", "Lorg/jetbrains/kotlin/compiler/plugin/CommandLineProcessor;", "()V", "pluginId", "", "getPluginId", "()Ljava/lang/String;", "pluginOptions", "", "Lorg/jetbrains/kotlin/compiler/plugin/CliOption;", "getPluginOptions", "()Ljava/util/Collection;", "processOption", "", "option", "Lorg/jetbrains/kotlin/compiler/plugin/AbstractCliOption;", "value", "configuration", "Lorg/jetbrains/kotlin/config/CompilerConfiguration;", "kotlin-compiler-native-plugin"})
public final class NativeCommandLineProcessor implements org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String pluginId = "helloWorldPlugin";
    @org.jetbrains.annotations.NotNull()
    private final java.util.Collection<org.jetbrains.kotlin.compiler.plugin.CliOption> pluginOptions = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getPluginId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.Collection<org.jetbrains.kotlin.compiler.plugin.CliOption> getPluginOptions() {
        return null;
    }
    
    @java.lang.Override()
    public void processOption(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.compiler.plugin.AbstractCliOption option, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.CompilerConfiguration configuration) {
    }
    
    public NativeCommandLineProcessor() {
        super();
    }
    
    public void processOption(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.compiler.plugin.CliOption option, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.CompilerConfiguration configuration) {
    }
    
    public <T extends java.lang.Object>void appendList(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.CompilerConfiguration $receiver, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.CompilerConfigurationKey<java.util.List<T>> option, T value) {
    }
    
    public <T extends java.lang.Object>void appendList(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.CompilerConfiguration $receiver, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.CompilerConfigurationKey<java.util.List<T>> option, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> values) {
    }
    
    public void applyOptionsFrom(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.CompilerConfiguration $receiver, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> map, @org.jetbrains.annotations.NotNull()
    java.util.Collection<? extends org.jetbrains.kotlin.compiler.plugin.AbstractCliOption> pluginOptions) {
    }
}