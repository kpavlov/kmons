plugins {
    id("kmons.kotlin-multiplatform-library")
}

kotlin {

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines)
            implementation(projects.kmonsLang)
        }
        commonTest.dependencies {
            implementation(libs.kotest.assertions)
            implementation(libs.kotlin.test)
            implementation(libs.kotlinx.coroutines.test)
        }
    }
}
