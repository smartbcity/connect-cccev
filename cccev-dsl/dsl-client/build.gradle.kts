plugins {
    id("city.smartb.fixers.gradle.kotlin.mpp")
    id("city.smartb.fixers.gradle.publish")
}

dependencies {
    commonMainApi(project(":cccev-f2:requirement-f2:requirement-f2-client"))
    commonMainApi(project(":cccev-dsl:dsl-model"))
}
