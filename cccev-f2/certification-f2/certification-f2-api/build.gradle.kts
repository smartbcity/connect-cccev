plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    id("city.smartb.fixers.gradle.publish")
    kotlin("plugin.spring")
}

dependencies {
    api(project(":cccev-f2:certification-f2:certification-f2-domain"))

    implementation(project(":cccev-f2:concept-f2:concept-f2-api"))
    implementation(project(":cccev-f2:evidence-f2:evidence-f2-api"))
    implementation(project(":cccev-s2:certification:certification-api"))

    Dependencies.Jvm.fs(::implementation)
}
