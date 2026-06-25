buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        // Detekt 2.x directly references KotlinBasePlugin at apply-time;
        // adding kotlin-gradle-plugin to the buildscript classpath makes it
        // visible to Detekt's isolated plugin classloader via parent delegation.
        classpath(libs.gradle.plugin.kotlin.multiplatform)
    }
}

plugins {
    alias(libs.plugins.detekt)
    alias(libs.plugins.dokka) apply false
    alias(libs.plugins.kover) apply false
    alias(libs.plugins.bcv) apply false
}

detekt {
    buildUponDefaultConfig = true
    allRules = false
    source.setFrom(
        fileTree("kmons-lang/src") { include("**/*.kt") },
        fileTree("kmons-coroutines/src") { include("**/*.kt") },
    )
}
