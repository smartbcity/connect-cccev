plugins {
    id("city.smartb.fixers.gradle.kotlin.jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation(project(":api-commons"))
    api(project(":cccev-f2:certification-f2:certification-f2-api"))
    api(project(":cccev-s2:certification:certification-api"))

    api("city.smartb.f2:f2-spring-boot-starter-function-http:${Versions.f2}")

    testImplementation(project(":cccev-test"))
}

subprojects {
    plugins.withType(JavaPlugin::class.java).whenPluginAdded {
        dependencies {
            val implementation by configurations
            implementation(project(":api-commons"))
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
