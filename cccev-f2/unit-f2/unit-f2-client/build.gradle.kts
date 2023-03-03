plugins {
	id("city.smartb.fixers.gradle.kotlin.mpp")
	id("city.smartb.fixers.gradle.publish")
	kotlin("plugin.serialization")
}

dependencies {
	commonMainApi(project(":cccev-f2:unit-f2:unit-f2-domain"))
	commonMainApi("city.smartb.f2:f2-client-ktor:${Versions.f2}")
}
