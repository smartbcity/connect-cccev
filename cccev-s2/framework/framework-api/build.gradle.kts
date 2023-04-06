plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	id("city.smartb.fixers.gradle.publish")
	kotlin("plugin.spring")
}

dependencies {
	api(project(":cccev-s2:framework:framework-domain"))
	api(project(":cccev-projection:projection-api"))
	Dependencies.Jvm.s2EventSouringBc(::implementation)
}
