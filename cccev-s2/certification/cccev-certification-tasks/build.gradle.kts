plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	id("city.smartb.fixers.gradle.publish")
	kotlin("plugin.spring")
}

dependencies {
	implementation(project(Modules.api.commons))

	implementation(project(Modules.cccev.s2.certification.api))
	implementation(project(Modules.cccev.f2.concept.domain))

	testImplementation(project(Modules.cccev.test))
	testImplementation(project(Modules.cccev.s2.requirement.api))
}
