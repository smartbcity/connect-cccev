plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	kotlin("plugin.spring")
}

dependencies {
	api(project(":cccev-s2:concept:concept-domain"))
}
