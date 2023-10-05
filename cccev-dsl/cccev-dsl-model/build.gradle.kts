plugins {
    id("city.smartb.fixers.gradle.kotlin.mpp")
    id("city.smartb.fixers.gradle.publish")
    kotlin("plugin.serialization")
}

dependencies {
    Dependencies.Jvm.junit(::jvmTestImplementation)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
