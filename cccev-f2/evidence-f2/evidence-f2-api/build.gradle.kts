plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    id("city.smartb.fixers.gradle.publish")
    kotlin("plugin.spring")
}

dependencies {
    api(project(":cccev-f2:evidence-f2:evidence-f2-domain"))
    implementation(project(":cccev-s2:request:request-api"))
    implementation(project(":cccev-s2:requirement:requirement-api"))
}
