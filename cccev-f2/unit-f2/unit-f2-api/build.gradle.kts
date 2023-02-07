plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    id("city.smartb.fixers.gradle.publish")
    kotlin("plugin.spring")
}

dependencies {
    api(project(":cccev-f2:unit-f2:unit-f2-domain"))

    implementation(project(":cccev-s2:unit:unit-api"))
}
