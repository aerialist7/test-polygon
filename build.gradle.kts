import org.jetbrains.kotlin.gradle.dsl.JsModuleKind
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
    kotlin("multiplatform")
}

kotlin {
    js {
        useEsModules()
        browser {
            commonWebpackConfig {
                outputFileName = "index.js"
            }
        }
        binaries.executable()
    }
}

tasks.withType<Kotlin2JsCompile>().configureEach {
    compilerOptions {
        moduleKind = JsModuleKind.MODULE_ES
        useEsClasses = true
    }
}

tasks.wrapper {
    gradleVersion = "8.7"
}
