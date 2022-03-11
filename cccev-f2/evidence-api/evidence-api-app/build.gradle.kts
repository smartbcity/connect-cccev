plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    id("city.smartb.fixers.gradle.publish")
    kotlin("plugin.spring")
}

dependencies {
    api(project(":cccev-f2:evidence-api:evidence-api-domain"))
    implementation(project(":cccev-s2:evidence:evidence-app"))
    implementation(project(":cccev-s2:request:request-app"))
    implementation(project(":cccev-s2:requirement:requirement-app"))
}
