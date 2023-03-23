plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation(project(":api-commons"))

    Dependencies.Jvm.fs(::implementation)
}
