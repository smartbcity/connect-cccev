plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    kotlin("plugin.spring")
}

dependencies {
    api(project(":cccev-f2:requirement-api:requirement-api-domain"))
    implementation(project(":cccev-s2:requirement:requirement-app"))
}
