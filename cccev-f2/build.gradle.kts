plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    id("city.smartb.fixers.gradle.publish")
    kotlin("plugin.spring")
}

dependencies {
    implementation(project(":api-commons"))
    api(project(":cccev-dsl:cccev-dsl-dto"))
    api(project(":cccev-s2:request:request-app"))

    api("city.smartb.f2:f2-spring-boot-starter-function-http:${Versions.f2}")

    testImplementation(project(":cccev-test"))
}

subprojects {
    plugins.withType(JavaPlugin::class.java).whenPluginAdded {
        dependencies {
            val implementation by configurations
            Dependencies.Jvm.f2 { implementation(it) }
        }
    }

    plugins.withType(org.jetbrains.kotlin.gradle.plugin.KotlinMultiplatformPluginWrapper::class.java).whenPluginAdded {
        dependencies {
            val commonMainApi by configurations
            Dependencies.Mpp.f2 { commonMainApi(it) }
        }
    }
}
