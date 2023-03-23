plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    id("city.smartb.fixers.gradle.publish")
    kotlin("plugin.spring")
}

dependencies {
    api(project(":cccev-f2:request-f2:request-f2-domain"))

    implementation(project(":cccev-f2:concept-f2:concept-f2-api"))
    implementation(project(":cccev-f2:evidence-f2:evidence-f2-api"))
    implementation(project(":cccev-s2:request:request-api"))

    Dependencies.Jvm.fs(::implementation)
}
