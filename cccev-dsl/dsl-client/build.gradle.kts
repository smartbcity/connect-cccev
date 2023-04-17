plugins {
    id("city.smartb.fixers.gradle.kotlin.mpp")
    id("city.smartb.fixers.gradle.publish")
}

dependencies {
    commonMainApi(project(":cccev-f2:concept-f2:concept-f2-client"))
    commonMainApi(project(":cccev-f2:evidence-type-f2:evidence-type-f2-client"))
    commonMainApi(project(":cccev-f2:framework-f2:framework-f2-client"))
    commonMainApi(project(":cccev-f2:certification-f2:certification-f2-client"))
    commonMainApi(project(":cccev-f2:requirement-f2:requirement-f2-client"))
    commonMainApi(project(":cccev-f2:unit-f2:unit-f2-client"))
    commonMainApi(project(":cccev-dsl:dsl-model"))
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
