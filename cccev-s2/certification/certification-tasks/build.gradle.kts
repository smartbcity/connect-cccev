plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	id("city.smartb.fixers.gradle.publish")
	kotlin("plugin.spring")
}

dependencies {
	implementation(project(":api-commons"))

	implementation(project(":cccev-s2:certification:certification-api"))
	implementation(project(":cccev-f2:concept-f2:concept-f2-domain"))

	testImplementation(project(":cccev-test"))
	testImplementation(project(":cccev-s2:requirement:requirement-api"))
}
