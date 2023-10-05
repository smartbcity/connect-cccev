plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	id("city.smartb.fixers.gradle.publish")
	kotlin("plugin.spring")
}

dependencies {
	api(project(Modules.cccev.s2.requirement.domain))
	api(project(Modules.cccev.projection.api))
	Dependencies.Jvm.s2EventSouringBc(::implementation)
}
