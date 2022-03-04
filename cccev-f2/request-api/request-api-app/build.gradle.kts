plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    kotlin("plugin.spring")
}

dependencies {
    api(project(":cccev-f2:concept-api:concept-api-app"))
    api(project(":cccev-f2:evidence-api:evidence-api-app"))
    api(project(":cccev-f2:request-api:request-api-domain"))
    implementation(project(":cccev-s2:request:request-app"))
}
