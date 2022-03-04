plugins {
    id("city.smartb.fixers.gradle.kotlin.mpp")
    kotlin("plugin.spring")
}

dependencies {
    commonMainApi(project(":cccev-f2:concept-api:concept-api-domain"))
    commonMainApi(project(":cccev-f2:evidence-api:evidence-api-domain"))
    commonMainApi(project(":cccev-s2:request:request-domain"))
}
