plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
	kotlin("plugin.spring")
}

dependencies {
	api("city.smartb.i2:i2-spring-boot-starter-auth:${Versions.i2}")
	api("city.smartb.im:api-config:${Versions.im}")

	Dependencies.Jvm.cucumber(::api)
	Dependencies.Jvm.f2(::api)
	Dependencies.Jvm.junit(::api)
	Dependencies.Jvm.s2Mongo(::api)
	Dependencies.Mpp.im(::api)
}
