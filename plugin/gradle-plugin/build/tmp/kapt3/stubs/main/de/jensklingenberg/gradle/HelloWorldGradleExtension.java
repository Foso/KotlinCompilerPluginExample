package de.jensklingenberg.gradle;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lde/jensklingenberg/gradle/HelloWorldGradleExtension;", "", "()V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "gradle-plugin"})
public class HelloWorldGradleExtension {
    
    /**
     * If [false], this plugin won't actually be applied 
     */
    private boolean enabled;
    
    /**
     * FQ names of elements that should count as elements 
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> annotations;
    
    public final boolean getEnabled() {
        return false;
    }
    
    public final void setEnabled(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getAnnotations() {
        return null;
    }
    
    public final void setAnnotations(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    public HelloWorldGradleExtension() {
        super();
    }
}