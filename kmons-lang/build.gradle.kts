plugins {
    id("kmons.kotlin-multiplatform-library")
}

kotlin {

    sourceSets {
        commonTest.dependencies {
            implementation(libs.kotest.assertions)
            implementation(libs.kotlin.test)
            implementation(libs.kotlinx.coroutines.test)
        }
    }
}
