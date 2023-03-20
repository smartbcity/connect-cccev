plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	kotlin("plugin.spring")
}

dependencies {
	api("city.smartb.i2:i2-spring-boot-starter-auth:${Versions.i2}")

	Dependencies.Jvm.Spring.dataCommons(::implementation)

	Dependencies.Jvm.cucumber(::api)
	Dependencies.Jvm.f2(::api)
	Dependencies.Mpp.s2(::implementation)
	Dependencies.Jvm.junit(::api)
}
