plugins {
    id("city.smartb.fixers.gradle.kotlin.mpp")
    kotlin("plugin.spring")
}

dependencies {
    commonMainApi(project(":cccev-s2:request:request-domain"))
}
