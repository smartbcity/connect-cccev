plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
}

dependencies {
	api(project(":cccev-dsl:cccev-dsl-core"))
	api(project(":cccev-dsl:cccev-dsl-dto"))
	api(project(":cccev-f2"))
	api(project(":cccev-s2:request:request-app"))

	Dependencies.Jvm.cucumber(::api)
	Dependencies.Jvm.junit(::api)

	api("org.springframework.boot:spring-boot-starter-test:${PluginVersions.springBoot}")
	api("org.springframework.boot:spring-boot-starter-data-mongodb:${PluginVersions.springBoot}")
	api("org.springframework.boot:spring-boot-starter-web:${PluginVersions.springBoot}")
}
