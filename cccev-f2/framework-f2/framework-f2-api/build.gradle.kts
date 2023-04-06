plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    id("city.smartb.fixers.gradle.publish")
    kotlin("plugin.spring")
}

dependencies {
    api(project(":cccev-f2:framework-f2:framework-f2-domain"))
    implementation(project(":cccev-s2:framework:framework-api"))
}
