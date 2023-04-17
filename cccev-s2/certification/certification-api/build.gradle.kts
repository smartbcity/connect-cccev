plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	id("city.smartb.fixers.gradle.publish")
	kotlin("plugin.spring")
}

dependencies {
	implementation(project(":api-commons"))

	api(project(":cccev-projection:projection-api"))
	api(project(":cccev-s2:certification:certification-domain"))
	api(project(":cccev-dsl:dsl-model"))
}
