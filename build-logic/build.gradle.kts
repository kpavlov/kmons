plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.gradle.plugin.kotlin.multiplatform)
    implementation(libs.gradle.plugin.dokka)
    implementation(libs.gradle.plugin.kover)
    implementation(libs.gradle.plugin.bcv)
}
