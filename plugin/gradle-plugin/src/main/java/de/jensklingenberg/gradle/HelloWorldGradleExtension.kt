package de.jensklingenberg.gradle

open class HelloWorldGradleExtension {
  /** If [false], this plugin won't actually be applied */
  var enabled: Boolean = true

  /** FQ names of elements that should count as elements */
  var annotations: List<String> = emptyList()
}
