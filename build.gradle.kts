plugins {
    kotlin("multiplatform")
    id("io.github.turansky.kfc.application")
    kotlin("plugin.js-plain-objects")
}

kotlin {
    js {
        binaries.executable()
    }
}

tasks.wrapper {
    gradleVersion = "8.8"
}
