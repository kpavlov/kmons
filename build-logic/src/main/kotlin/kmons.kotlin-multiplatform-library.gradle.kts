plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.dokka")
    id("org.jetbrains.kotlinx.kover")
    id("org.jetbrains.kotlinx.binary-compatibility-validator")
}

kotlin {
    explicitApi()
    jvmToolchain(21)

    jvm()
    iosArm64()
    iosSimulatorArm64()
    js {
        browser()
        nodejs()
    }
}
