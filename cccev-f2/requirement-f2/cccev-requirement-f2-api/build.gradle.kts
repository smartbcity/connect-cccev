plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    id("city.smartb.fixers.gradle.publish")
    kotlin("plugin.spring")
}

dependencies {
    api(project(Modules.cccev.f2.requirement.domain))

    implementation(project(Modules.cccev.f2.concept.api))
    implementation(project(Modules.cccev.f2.evidenceType.api))

    implementation(project(Modules.cccev.s2.requirement.api))
}
