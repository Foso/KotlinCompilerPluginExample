
<h1 align="center">KotlinCompilerPluginExample </h1>

[![jCenter](https://img.shields.io/badge/Apache-2.0-green.svg
)](https://github.com/Foso/KotlinReactNativeMpp/blob/master/LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)
[![jCenter](https://img.shields.io/badge/Kotlin-2.0.0-green.svg
)](https://github.com/Foso/Sheasy/blob/master/LICENSE)



## Introduction 🙋‍♂️

This is an example project that shows how to create a Kotlin Compiler Plugin. At compile time a gradle plugin will trigger the compiler plugin. The plugin will print "Hello from" and the name of the file that is being compiled, as a compiler warning to the terminal log.

<p>
    <img src ="https://raw.githubusercontent.com/Foso/KotlinCompilerPluginExample/master/docs/screenshot.png" />
 
</p>

### Show some :heart: and star the repo to support the project

[![GitHub stars](https://img.shields.io/github/stars/Foso/KotlinCompilerPluginExample.svg?style=social&label=Star)](https://github.com/Foso/KotlinCompilerPluginExample) [![GitHub forks](https://img.shields.io/github/forks/Foso/KotlinCompilerPluginExample.svg?style=social&label=Fork)](https://github.com/Foso/KotlinCompilerPluginExample/fork) [![GitHub watchers](https://img.shields.io/github/watchers/Foso/KotlinCompilerPluginExample.svg?style=social&label=Watch)](https://github.com/Foso/KotlinCompilerPluginExample) [![Twitter Follow](https://img.shields.io/twitter/follow/jklingenberg_.svg?style=social)](https://twitter.com/jklingenberg_)


## Usage

> :information_source: Please be aware that the Kotlin Compiler still doesn't have any stable API and there is no
> backwards compatibility guaranteed. Kotlin versions above 1.9.23 can have a totally different API.

* Inside the project folder run `./gradlew clean build` 

The plugin is only active when the build cache is changed. This is why you need to run "clean" before building, when you want to see the log output again.

### 👷 Project Structure
*  <kbd>lib</kbd> - A Kotlin Multiplatform project which applies a gradle plugin(compiler.plugin.helloworld) which triggers the compiler plugin.
*  <kbd>compiler-plugin</kbd> - This module contains the Kotlin Compiler Plugin
*  <kbd>gradle-plugin</kbd> - This module contains the gradle plugin which trigger the compiler plugin

## Useful resources
[The Road to the New Kotlin Compiler](https://www.youtube.com/watch?v=iTdJJq_LyoY)

[https://github.com/bnorm/kotlin-ir-plugin-template](https://github.com/bnorm/kotlin-ir-plugin-template)

[Writing Your Second Kotlin Compiler Plugin, Part 1 — Project Setup](https://blog.bnorm.dev/writing-your-second-compiler-plugin-part-1)

[Experimenting with the Kotlin Compiler by Jossi Wolf, Snapp Mobile EN](https://www.youtube.com/watch?v=Y6gEA-nS2uQ)

[Crash course on the Kotlin compiler | 1. Frontend: Parsing phase](https://medium.com/google-developer-experts/crash-course-on-the-kotlin-compiler-1-frontend-parsing-phase-9898490d922b)

## ✍️ Feedback

Feel free to send feedback on [Twitter](https://twitter.com/jklingenberg_) or [file an issue](https://github.com/foso/KotlinCompilerPluginExample/issues/new). Feature requests are always welcome.


### Find this project useful ? :heart:
* Support it by clicking the :star: button on the upper right of this page. :v:

## 📜 License

-------

This project is licensed under Apache License, Version 2.0

    Copyright 2019 Jens Klingenberg

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


## Acknowledgments
Projects that helped me understand how to setup the project:
* [kevinmost/debuglog](https://github.com/kevinmost/debuglog)
* [ZacSweers/redacted-compiler-plugin](https://github.com/ZacSweers/redacted-compiler-plugin)
* [hotchemi/kotlin-compiler-plugin-example
](https://github.com/hotchemi/kotlin-compiler-plugin-example)
* [Takhion/sample-kotlin-compiler-plugin](https://github.com/Takhion/sample-kotlin-compiler-plugin)
