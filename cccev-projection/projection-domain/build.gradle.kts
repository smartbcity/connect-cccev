plugins {
	id("city.smartb.fixers.gradle.kotlin.mpp")
	id("city.smartb.fixers.gradle.publish")
	kotlin("plugin.serialization")
}

dependencies {
	commonMainApi(project(":cccev-s2:concept:concept-domain"))
	commonMainApi(project(":cccev-s2:evidence-type:evidence-type-domain"))
	commonMainApi(project(":cccev-s2:framework:framework-domain"))
	commonMainApi(project(":cccev-s2:certification:certification-domain"))
	commonMainApi(project(":cccev-s2:requirement:requirement-domain"))
	commonMainApi(project(":cccev-s2:unit:unit-domain"))
}
