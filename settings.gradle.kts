
includeBuild("gradle-plugin") {
    dependencySubstitution {
        substitute(module("de.jensklingenberg:gradle-plugin:1.0.0")).using(project(":"))
    }
}
includeBuild("compiler-plugin")

include(":lib")
