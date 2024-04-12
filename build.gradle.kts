import org.jetbrains.kotlin.gradle.dsl.JsModuleKind
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

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

tasks.withType<KotlinCompilationTask<*>>().configureEach {
    compilerOptions {
        freeCompilerArgs.addAll(
            "-Xir-generate-inline-anonymous-functions",
        )
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
