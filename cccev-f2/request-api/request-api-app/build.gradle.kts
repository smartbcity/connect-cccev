plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    kotlin("plugin.spring")
}

dependencies {
    api(project(":cccev-f2:request-api:request-api-domain"))
    implementation(project(":cccev-s2:request:request-app"))
}
