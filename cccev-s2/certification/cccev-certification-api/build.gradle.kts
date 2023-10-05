plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	id("city.smartb.fixers.gradle.publish")
	kotlin("plugin.spring")
}

dependencies {
	implementation(project(Modules.api.commons))

	api(project(Modules.cccev.projection.api))
	api(project(Modules.cccev.s2.certification.domain))
	api(project(Modules.cccev.dsl.model))
}
