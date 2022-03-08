plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    id("city.smartb.fixers.gradle.publish")
    kotlin("plugin.spring")
}

dependencies {
    api(project(":cccev-f2:concept-api:concept-api-domain"))
    implementation(project(":cccev-s2:concept:concept-app"))
    implementation(project(":cccev-s2:request:request-app"))
    implementation(project(":cccev-s2:requirement:requirement-app"))
}
