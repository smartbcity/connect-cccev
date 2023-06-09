plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("city.smartb.fixers.gradle.kotlin.jvm")
    kotlin("plugin.spring")
}

dependencies {
    Dependencies.Jvm.f2Http(::api)

    implementation(project(":cccev-f2"))
    implementation(project(":cccev-f2:concept-f2:concept-f2-api"))
    implementation(project(":cccev-f2:evidence-f2:evidence-f2-api"))
    implementation(project(":cccev-f2:evidence-type-f2:evidence-type-f2-api"))
    implementation(project(":cccev-f2:framework-f2:framework-f2-api"))
    implementation(project(":cccev-f2:certification-f2:certification-f2-api"))
    implementation(project(":cccev-f2:requirement-f2:requirement-f2-api"))
    implementation(project(":cccev-f2:unit-f2:unit-f2-api"))

    implementation(project(":cccev-s2:concept:concept-api"))
    implementation(project(":cccev-s2:evidence-type:evidence-type-api"))
    implementation(project(":cccev-s2:certification:certification-tasks"))
    implementation(project(":cccev-s2:requirement:requirement-api"))

    implementation(project(":api-commons"))
    implementation(project(":api-config"))
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootBuildImage> {
    imageName.set("smartbcity/cccev-gateway:${this.project.version}")
}
