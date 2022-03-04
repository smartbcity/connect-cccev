plugins {
    id("city.smartb.fixers.gradle.kotlin.mpp")
    id("city.smartb.fixers.gradle.publish")
}

dependencies {
    commonMainApi(project(":cccev-core:cccev-core-dsl"))

    commonMainApi(project(":cccev-f2:concept-api:concept-api-domain"))
    commonMainApi(project(":cccev-f2:evidence-api:evidence-api-domain"))
    commonMainApi(project(":cccev-f2:request-api:request-api-domain"))
    commonMainApi(project(":cccev-f2:requirement-api:requirement-api-domain"))

    jvmApi(project(":cccev-f2:concept-api:concept-api-app"))
    jvmApi(project(":cccev-f2:evidence-api:evidence-api-app"))
    jvmApi(project(":cccev-f2:request-api:request-api-app"))
    jvmApi(project(":cccev-f2:requirement-api:requirement-api-app"))

    jvmRuntimeOnly(project(":cccev-s2:request:request-tasks"))
}
