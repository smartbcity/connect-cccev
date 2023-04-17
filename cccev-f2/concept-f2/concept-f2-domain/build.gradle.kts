plugins {
    id("city.smartb.fixers.gradle.kotlin.mpp")
    id("city.smartb.fixers.gradle.publish")
    kotlin("plugin.spring")
    kotlin("plugin.serialization")
}

dependencies {
    commonMainApi(project(":cccev-f2:evidence-f2:evidence-f2-domain"))
    commonMainApi(project(":cccev-f2:unit-f2:unit-f2-domain"))
    commonMainApi(project(":cccev-s2:concept:concept-domain"))
    commonMainApi(project(":cccev-s2:certification:certification-domain"))
}
