plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	id("city.smartb.fixers.gradle.publish")
	kotlin("plugin.spring")
}

dependencies {
	api(project(":cccev-s2:request:request-domain"))
	api(project(":cccev-core:cccev-core-dsl"))

	Dependencies.Jvm.s2Mongo(::api)
}
