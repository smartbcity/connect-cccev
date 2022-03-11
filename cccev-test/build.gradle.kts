plugins {
	id("city.smartb.fixers.gradle.kotlin.jvm")
}

dependencies {
	api(project(":cccev-core:cccev-core-dsl"))
	api(project(":cccev-f2"))
	api(project(":cccev-s2:concept:concept-app"))
	api(project(":cccev-s2:evidence:evidence-app"))
	api(project(":cccev-s2:request:request-app"))
	api(project(":cccev-s2:requirement:requirement-app"))

	Dependencies.Jvm.cucumber(::api)
	Dependencies.Jvm.junit(::api)

	api("org.springframework.boot:spring-boot-starter-test:${PluginVersions.springBoot}")
	api("org.springframework.boot:spring-boot-starter-data-mongodb:${PluginVersions.springBoot}")
	api("org.springframework.boot:spring-boot-starter-web:${PluginVersions.springBoot}")
}
